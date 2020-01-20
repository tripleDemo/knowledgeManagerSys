package com.huashang.core.service;

import java.util.List;
import com.huashang.core.dto.CommentDto;
import com.huashang.core.pojo.Comments;

public interface CommentsService extends BaseService<Comments> {

	List<CommentDto> likeByCommentContent(Long start, Integer pageSize, String commentContent);

}
