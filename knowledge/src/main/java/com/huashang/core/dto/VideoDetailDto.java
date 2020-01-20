package com.huashang.core.dto;

import java.util.List;

public class VideoDetailDto extends VideoDto {
	private static final long serialVersionUID = 1L;

	private String videoUrl;
	
	private String videoDes;
	
	private List<CommentDto> comment;

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public String getVideoDes() {
		return videoDes;
	}
	
	public void setVideoDes(String videoDes) {
		this.videoDes = videoDes;
	}
	
	public List<CommentDto> getComment() {
		return comment;
	}

	public void setComment(List<CommentDto> comment) {
		this.comment = comment;
	}
	
}
