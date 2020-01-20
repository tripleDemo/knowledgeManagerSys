package com.huashang.core.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.huashang.common.utils.AliyunOSSUtil;
import com.huashang.common.utils.OssUtil;
import com.huashang.common.utils.Result;
import com.huashang.common.utils.StatusCode;

@CrossOrigin
@RestController
public class FileUploadController {
//	@Autowired
//	private OssUtil ossUtil;

	@Autowired
	private HttpServletRequest request;

	/**
	 * 上传文件，返回存储文件路径(执行此操作的管理员需携带token)
	 * @param map
	 * @return 
	 * @throws IOException 
	 */
	@PostMapping("/video/upload")
	public Result fileUpload(@RequestParam("file")  MultipartFile uploadfile) {
		System.out.println(uploadfile.getSize());
		String token = (String) request.getAttribute("claims_admin");
		if(token != null && !"".equals(token)) { //拥有权限即可执行操作
			if (uploadfile != null) {
				//				String filePath = ossUtil.uploadFile(uploadfile);
				try {
					String filePath = AliyunOSSUtil.uploadToOSSFile(uploadfile);
					if(filePath != null) 
						return new Result(true, StatusCode.OK, "上传文件成功", filePath);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return new Result(false, StatusCode.ERROR, "上传文件失败");
	}
}
