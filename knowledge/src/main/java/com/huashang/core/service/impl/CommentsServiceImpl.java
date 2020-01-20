package com.huashang.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huashang.core.dto.CommentDto;
import com.huashang.core.mapper.CommentsMapper;
import com.huashang.core.pojo.Comments;
import com.huashang.core.service.CommentsService;

@Service
public class CommentsServiceImpl implements CommentsService {
	@Autowired
	private CommentsMapper commentsMapper;
	
	@Override
	public int deleteByPrimaryKey(String id) {
		return commentsMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Comments comment) {
		return commentsMapper.insert(comment);
	}

	@Override
	public Comments selectByPrimaryKey(String id) {
		return commentsMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Comments> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKey(Comments t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<CommentDto> likeByCommentContent(Long start, Integer pageSize, String commentContent) {
		return commentsMapper.likeByCommentContent(start, pageSize, commentContent);
	}

}
