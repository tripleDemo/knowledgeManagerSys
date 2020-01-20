package com.huashang.core.service;

import java.util.List;
import com.huashang.core.dto.VideoDetailDto;
import com.huashang.core.dto.VideoDto;
import com.huashang.core.pojo.Videos;

public interface VideosService extends BaseService<Videos> {

	List<VideoDto> likeByVideoTitle(Long start, Integer pageSize, String videoTitle);

	VideoDetailDto selectVideoAndCommentsByVideoId(String videoId);
}
