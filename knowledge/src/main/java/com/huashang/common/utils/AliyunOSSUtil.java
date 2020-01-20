package com.huashang.common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.CompleteMultipartUploadRequest;
import com.aliyun.oss.model.InitiateMultipartUploadRequest;
import com.aliyun.oss.model.InitiateMultipartUploadResult;
import com.aliyun.oss.model.PartETag;
import com.aliyun.oss.model.UploadPartRequest;
import com.aliyun.oss.model.UploadPartResult;

public class AliyunOSSUtil {
	// 具体查看阿里云官方文档
	public static final String ENDPOINT = "http://oss-cn-shenzhen.aliyuncs.com";

	public static final String ACCESSKEYID = "ACCESSKEYID";

	public static final String ACCESSKEYSECRET = "ACCESSKEYSECRET";

	public static final String BUCKETNAME = "BUCKETNAME";
	// <yourObjectName>表示删除OSS文件时需要指定包含文件后缀在内的完整路径，例如abc/efg/123.jpg。
	private static String objectName = "knowledge/";
	
	public static String uploadToOSSFile(MultipartFile file) throws IOException {
		objectName += (UUID.randomUUID() + file.getOriginalFilename()); // 获取文件url
		// 创建OSSClient实例。
		OSS ossClient = new OSSClientBuilder().build(ENDPOINT, ACCESSKEYID, ACCESSKEYSECRET);

		// 创建InitiateMultipartUploadRequest对象。
		InitiateMultipartUploadRequest request = new InitiateMultipartUploadRequest(BUCKETNAME, objectName);

		// 如果需要在初始化分片时设置文件存储类型，请参考以下示例代码。
		// ObjectMetadata metadata = new ObjectMetadata();
		// metadata.setHeader(OSSHeaders.OSS_STORAGE_CLASS, StorageClass.Standard.toString());
		// request.setObjectMetadata(metadata);

		// 初始化分片。
		InitiateMultipartUploadResult upresult = ossClient.initiateMultipartUpload(request);
		// 返回uploadId，它是分片上传事件的唯一标识，您可以根据这个ID来发起相关的操作，如取消分片上传、查询分片上传等。
		String uploadId = upresult.getUploadId();

		// partETags是PartETag的集合。PartETag由分片的ETag和分片号组成。
		List<PartETag> partETags = new ArrayList<PartETag>();
		// 计算文件有多少个分片。
		final long partSize = 1 * 1024 * 1024L;   // 1MB
		//MultipartFile转File
		//        File sampleFile=new File(file.getOriginalFilename());
		//        FileOutputStream os=new FileOutputStream(sampleFile);
		//        os.write(file.getBytes());
		//        os.close();
		//        file.transferTo(sampleFile);//将上传文件写入目标文件
		//    
		//		long fileLength = sampleFile.length();
		long fileLength = file.getSize(); // 获取文件总大小
		int partCount = (int) (fileLength / partSize);
		if (fileLength % partSize != 0) {
			partCount++;
		}
		// 遍历分片上传。
		for (int i = 0; i < partCount; i++) {
			long startPos = i * partSize;
			long curPartSize = (i + 1 == partCount) ? (fileLength - startPos) : partSize;
			InputStream instream = file.getInputStream();
			// 跳过已经上传的分片。
			instream.skip(startPos);
			UploadPartRequest uploadPartRequest = new UploadPartRequest();
			uploadPartRequest.setBucketName(BUCKETNAME);
			uploadPartRequest.setKey(objectName);
			uploadPartRequest.setUploadId(uploadId);
			uploadPartRequest.setInputStream(instream);
			// 设置分片大小。除了最后一个分片没有大小限制，其他的分片最小为100KB。
			uploadPartRequest.setPartSize(curPartSize);
			// 设置分片号。每一个上传的分片都有一个分片号，取值范围是1~10000，如果超出这个范围，OSS将返回InvalidArgument的错误码。
			uploadPartRequest.setPartNumber( i + 1);
			// 每个分片不需要按顺序上传，甚至可以在不同客户端上传，OSS会按照分片号排序组成完整的文件。
			UploadPartResult uploadPartResult = ossClient.uploadPart(uploadPartRequest);
			// 每次上传分片之后，OSS的返回结果会包含一个PartETag。PartETag将被保存到partETags中。
			partETags.add(uploadPartResult.getPartETag());
		}


		// 创建CompleteMultipartUploadRequest对象。
		// 在执行完成分片上传操作时，需要提供所有有效的partETags。OSS收到提交的partETags后，会逐一验证每个分片的有效性。当所有的数据分片验证通过后，OSS将把这些分片组合成一个完整的文件。
		CompleteMultipartUploadRequest completeMultipartUploadRequest =
				new CompleteMultipartUploadRequest(BUCKETNAME, objectName, uploadId, partETags);

		// 如果需要在完成文件上传的同时设置文件访问权限，请参考以下示例代码。
		// completeMultipartUploadRequest.setObjectACL(CannedAccessControlList.PublicRead);

		// 完成上传。
		ossClient.completeMultipartUpload(completeMultipartUploadRequest);

		//设置url过期时间为1小时
		Date expiration = new Date(new Date().getTime() + 100 * 3600 * 10000);
		// 获取url
		URL url = ossClient.generatePresignedUrl(BUCKETNAME, objectName, expiration);
		// 关闭OSSClient。
		ossClient.shutdown();
		System.out.println(url.toString());
		return url.toString();
	}
}
