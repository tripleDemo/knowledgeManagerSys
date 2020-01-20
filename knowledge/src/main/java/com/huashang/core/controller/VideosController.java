package com.huashang.core.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.huashang.common.utils.JWTUtil;
import com.huashang.common.utils.Result;
import com.huashang.common.utils.StatusCode;
import com.huashang.core.dto.VideoDetailDto;
import com.huashang.core.dto.VideoDto;
import com.huashang.core.pojo.Videos;
import com.huashang.core.service.VideosService;
import io.jsonwebtoken.Claims;

@CrossOrigin
@RestController
public class VideosController {
	@Autowired
	private VideosService videosService;

	@Autowired
	HttpServletRequest request;

	@Autowired
	private JWTUtil jWTUtil;

	/**
	 * 添加视频(执行此操作的管理员需携带token)
	 * @param video
	 * @return
	 */
	@PostMapping("/video/add")
	public Result addVideo(@RequestBody Videos video) {
		System.out.println(video);
		String token = (String) request.getAttribute("claims_admin");
		if(token != null && !"".equals(token)) { //拥有权限即可执行操作
			Claims claims = null;
			try{
				claims = jWTUtil.parseJWT(token);
			}catch (RuntimeException e){
				return new Result(false, StatusCode.TOKENERROR, "权限不足");
			}
			String adminId = claims.getId();
			video.setAdminId(adminId);
			video.setVideoId(String.valueOf(UUID.randomUUID()));
			video.setCreatedAt(new Date());
			int insertNums = videosService.insert(video);
			if(insertNums > 0) 
				return new Result(true,StatusCode.OK, "添加视频成功");

		}
		return new Result(false, StatusCode.ERROR, "添加视频失败");
	}

	/**
	 * 修改视频(执行此操作的管理员需携带token)
	 * @param video
	 * @return
	 */
	@PutMapping("/video/update")
	public Result updateVideo(@RequestBody Videos video) {
		String token = (String) request.getAttribute("claims_admin");
		if(token != null && !"".equals(token)) { //拥有权限即可执行操作
			Claims claims = null;
			try{
				claims = jWTUtil.parseJWT(token);
			}catch (RuntimeException e){
				return new Result(false, StatusCode.TOKENERROR, "权限不足");
			}
			video.setUpdatedAt(new Date());
			int updateNums = videosService.updateByPrimaryKey(video);
			if(updateNums > 0) 
				return new Result(true,StatusCode.OK, "修改视频成功");

		}
		return new Result(false, StatusCode.ERROR, "修改视频失败");
	}

	/**
	 * 删除视频(执行此操作的管理员需携带token)
	 * @param videoId
	 * @return
	 */
	@DeleteMapping("/video/delete")
	public Result deleteVideo(@RequestParam("videoId") String videoId) {
		String token = (String) request.getAttribute("claims_admin");
		if(token != null && !"".equals(token)) { //拥有权限即可执行操作
			Claims claims = null;
			try{
				claims = jWTUtil.parseJWT(token);
			}catch (RuntimeException e){
				return new Result(false, StatusCode.TOKENERROR, "权限不足");
			}
			int deleteNums = videosService.deleteByPrimaryKey(videoId);
			if(deleteNums > 0) 
				return new Result(true,StatusCode.OK, "删除视频成功");

		}
		return new Result(false, StatusCode.ERROR, "删除视频失败");
	}

	/**
	 * 根据视频名称模糊查询分页获取视频数据(执行此操作的管理员或用户需携带token)
	 * @param currentPage
	 * @param pageSize
	 * @param username
	 * @return
	 */
	@GetMapping(value = {"/video/{currentPage}/{pageSize}"})
	public Result getVideosPageResultlikeByTitle(@PathVariable Long currentPage, 
			@PathVariable Integer pageSize, 
			@RequestParam("search") String videoTitle) {
		if(currentPage > 0 && pageSize > 0) {
//			String userToken = (String) request.getAttribute("claims_user");
//			String adminToken = (String) request.getAttribute("claims_admin");
//			//拥有权限即可执行操作
//			if((userToken != null && !"".equals(userToken)) || (adminToken != null && !"".equals(adminToken))) { 
				List<VideoDto> videos = videosService.likeByVideoTitle((currentPage - 1) * pageSize, pageSize, videoTitle);
				Long total = (long) videosService.likeByVideoTitle(null, null, videoTitle).size();
				Map<String, Object> resultMap = new HashMap<String, Object>();
				resultMap.put("videos", videos);
				resultMap.put("total", total);
				return new Result(true, StatusCode.OK, "根据视频名称模糊查询分页获取视频数据成功", resultMap);
//			}else {
//				return new Result(false, StatusCode.TOKENERROR, "权限不足");
//			}
		}
		return new Result(false, StatusCode.ERROR, "根据视频名称模糊查询分页获取视频数据失败");	
	}

	/**
	 * 根据视频id获取视频及评论数据(用户需携带token)
	 * @param videoId
	 * @return
	 */
	@GetMapping("/video")
	public Result getVideoAndComments(@RequestParam("videoId") String videoId) {
		String userToken = (String) request.getAttribute("claims_user");
		String adminToken = (String) request.getAttribute("claims_admin");
		//拥有权限即可执行操作
		if((userToken != null && !"".equals(userToken)) || (adminToken != null && !"".equals(adminToken))) { 
			VideoDetailDto videoAndComments = videosService.selectVideoAndCommentsByVideoId(videoId);
			if(videoAndComments != null)
				return new Result(true, StatusCode.OK, "根据视频id获取视频及评论数据成功", videoAndComments);
		}else {
			return new Result(false, StatusCode.TOKENERROR, "权限不足");
		}
		return new Result(false, StatusCode.ERROR, "根据视频id获取视频及评论数据失败");	
	}
}
