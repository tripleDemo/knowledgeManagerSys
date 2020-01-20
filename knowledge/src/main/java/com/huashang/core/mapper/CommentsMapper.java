package com.huashang.core.mapper;

import com.huashang.core.dto.CommentDto;
import com.huashang.core.pojo.Comments;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CommentsMapper {
    int deleteByPrimaryKey(String commentId);

    int insert(Comments record);

    Comments selectByPrimaryKey(String commentId);

    List<Comments> selectAll();

    int updateByPrimaryKey(Comments record);
    
    List<CommentDto> likeByCommentContent(@Param("start") Long start, @Param("pageSize") Integer pageSize, @Param("commentContent") String commentContent);
    
    List<CommentDto> selectByVideoId(@Param("videoId") String videoId);
}