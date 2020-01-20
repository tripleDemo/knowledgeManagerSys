package com.huashang.common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;

@Component
public class OssUtil {
	// 具体查看阿里云官方文档
	public static final String ENDPOINT = "http://oss-ENDPOINT-shenzhen.aliyuncs.com";
	
	public static final String ACCESSKEYID = "ACCESSKEYID";
	
	public static final String ACCESSKEYSECRET = "ACCESSKEYSECRET";
	
	public static final String BUCKETNAME = "BUCKETNAME";
	// <yourObjectName>表示删除OSS文件时需要指定包含文件后缀在内的完整路径，例如abc/efg/123.jpg。
	private String objectName = "knowledge/";
	
	/**
	 * 上传文件流
	 * @param objectName
	 * @param file
	 * @return
	 */
	public String uploadFile(MultipartFile file) {
		// 创建OSSClient实例。
		OSS ossClient = new OSSClientBuilder().build(ENDPOINT, ACCESSKEYID, ACCESSKEYSECRET);
		
		// 上传文件流
        InputStream inputStream = null;
		try {
			inputStream = file.getInputStream();
		} catch (IOException e) {
			return null;
		}
		objectName += (UUID.randomUUID() + file.getOriginalFilename()); // 获取文件url

		ossClient.putObject(BUCKETNAME, objectName, inputStream);
		//设置url过期时间为1小时
		Date expiration = new Date(new Date().getTime() + 3600 * 10000);
		//获取url
		URL url = ossClient.generatePresignedUrl(BUCKETNAME, objectName, expiration);
		// 关闭OSSClient。
		ossClient.shutdown();
		System.out.println(url.toString());
		return url.toString();
	}

	public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}
}
