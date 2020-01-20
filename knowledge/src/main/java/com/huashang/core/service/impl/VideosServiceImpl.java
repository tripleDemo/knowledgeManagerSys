package com.huashang.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huashang.core.dto.VideoDetailDto;
import com.huashang.core.dto.VideoDto;
import com.huashang.core.mapper.VideosMapper;
import com.huashang.core.pojo.Videos;
import com.huashang.core.service.VideosService;

@Service
public class VideosServiceImpl implements VideosService {
	@Autowired
	private VideosMapper videosMapper;

	@Override
	public int deleteByPrimaryKey(String id) {
		return videosMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Videos video) {
		return videosMapper.insert(video);
	}

	@Override
	public Videos selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Videos> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKey(Videos video) {
		return videosMapper.updateByPrimaryKey(video);
	}

	@Override
	public List<VideoDto> likeByVideoTitle(Long start, Integer pageSize, String videoTitle) {
		return videosMapper.likeByVideoTitle(start, pageSize, videoTitle);
	}

	@Override
	public VideoDetailDto selectVideoAndCommentsByVideoId(String videoId) {
		return videosMapper.selectVideoAndCommentsByVideoId(videoId);
	}

}
