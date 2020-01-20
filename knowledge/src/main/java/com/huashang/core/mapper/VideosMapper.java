package com.huashang.core.mapper;

import com.huashang.core.dto.VideoDetailDto;
import com.huashang.core.dto.VideoDto;
import com.huashang.core.pojo.Videos;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VideosMapper {
    int deleteByPrimaryKey(String videoId);

    int insert(Videos record);

    Videos selectByPrimaryKey(String videoId);

    List<Videos> selectAll();

    int updateByPrimaryKey(Videos record);
    
    List<VideoDto> likeByVideoTitle(@Param("start") Long start, @Param("pageSize") Integer pageSize, @Param("videoTitle") String videoTitle);
    
    VideoDetailDto selectVideoAndCommentsByVideoId(@Param("videoId") String videoId);
}