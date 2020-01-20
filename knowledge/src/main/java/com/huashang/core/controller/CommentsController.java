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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.huashang.common.utils.JWTUtil;
import com.huashang.common.utils.Result;
import com.huashang.common.utils.StatusCode;
import com.huashang.core.dto.CommentDto;
import com.huashang.core.pojo.Comments;
import com.huashang.core.pojo.Users;
import com.huashang.core.service.CommentsService;
import io.jsonwebtoken.Claims;

@CrossOrigin
@RestController
public class CommentsController {
	@Autowired
	private CommentsService commentsService;

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private JWTUtil jWTUtil;

	/**
	 * 添加评论(用户需携带token)
	 * @param comment
	 * @return
	 */
	@PostMapping("/comment/video")
	public Result insertComment(@RequestBody Comments comment) {
		String token = (String) request.getAttribute("claims_user");
		if(token != null && !"".equals(token)) { //拥有权限即可执行操作
			Claims claims = null;
			try{
				claims = jWTUtil.parseJWT(token);
			}catch (RuntimeException e){
				return new Result(false, StatusCode.TOKENERROR, "权限不足");
			}
			String userId = claims.getId();
			comment.setUserId(userId);
			comment.setCommentId(String.valueOf(UUID.randomUUID()));
			comment.setCreatedAt(new Date());
			int insertNums = commentsService.insert(comment);
			if(insertNums > 0)
				return new Result(true, StatusCode.OK, "评论成功");
		}
		return new Result(false, StatusCode.ERROR, "评论失败");	
	}

	/**
	 * 删除评论(用户需携带token)
	 * @param commentId
	 * @return
	 */
	@DeleteMapping("/comment/delete")
	public Result insertComment(@RequestParam("commentId") String commentId) {
		String token = (String) request.getAttribute("claims_user");
		String adminToken = (String) request.getAttribute("claims_admin");
		//拥有权限即可执行操作
		if(token != null && !"".equals(token)) { //拥有权限即可执行操作
			Claims claims = null;
			try{
				claims = jWTUtil.parseJWT(token);
			}catch (RuntimeException e){
				return new Result(false, StatusCode.TOKENERROR, "权限不足");
			}
			String carryUserId = claims.getId();
			String userId = commentsService.selectByPrimaryKey(commentId).getUserId();
			if(carryUserId != null && carryUserId.equals(userId)) { //用户只能删除自己的评论
				int deleteNums = commentsService.deleteByPrimaryKey(commentId);
				if(deleteNums > 0)
					return new Result(true, StatusCode.OK, "删除评论成功");
			}else {
				return new Result(false, StatusCode.ERROR, "用户只能删除自己的评论！");	
			}
		}else if(adminToken != null && !"".equals(adminToken)) { 
			int deleteNums = commentsService.deleteByPrimaryKey(commentId);
			if(deleteNums > 0)
				return new Result(true, StatusCode.OK, "删除评论成功");
		}
		return new Result(false, StatusCode.ERROR, "删除评论失败");	
	}

	/**
	 * 根据评论内容模糊查询分页获取评论数据(执行此操作的管理员或用户需携带token)
	 * @param currentPage
	 * @param pageSize
	 * @param commentContent
	 * @return
	 */
	@GetMapping(value= {"/comment/{currentPage}/{pageSize}"})
	public Result getCommentsPageResultlikeByContent(@PathVariable Long currentPage, 
			@PathVariable Integer pageSize, 
			@RequestParam("search") String commentContent) {
		if(currentPage > 0 && pageSize > 0) {
			String userToken = (String) request.getAttribute("claims_user");
			String adminToken = (String) request.getAttribute("claims_admin");
			//拥有权限即可执行操作
			if((userToken != null && !"".equals(userToken)) || (adminToken != null && !"".equals(adminToken))) { 
				List<CommentDto> comments = commentsService.likeByCommentContent((currentPage - 1) * pageSize, pageSize, commentContent);
				Long total = (long) commentsService.likeByCommentContent(null, null, commentContent).size();
				Map<String, Object> resultMap = new HashMap<String, Object>();
				resultMap.put("comments", comments);
				resultMap.put("total", total);
				return new Result(true, StatusCode.OK, "根据评论内容模糊查询分页获取评论数据成功", resultMap);
			}else {
				return new Result(false, StatusCode.TOKENERROR, "权限不足");
			}
		}
		return new Result(false, StatusCode.ERROR, "根据评论内容模糊查询分页获取评论数据失败");	
	}
}
