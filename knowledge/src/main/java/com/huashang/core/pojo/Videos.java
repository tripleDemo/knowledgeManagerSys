package com.huashang.core.pojo;

import java.io.Serializable;
import java.util.Date;

public class Videos implements Serializable {
	private static final long serialVersionUID = 1L;

	private String videoId;

    private String videoUrl;

    private String videoTitle;

    private String videoImage;

    private Date createdAt;

    private Date updatedAt;

    private String adminId;

    private String videoDes;

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public String getVideoImage() {
        return videoImage;
    }

    public void setVideoImage(String videoImage) {
        this.videoImage = videoImage;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getVideoDes() {
        return videoDes;
    }

    public void setVideoDes(String videoDes) {
        this.videoDes = videoDes;
    }

	@Override
	public String toString() {
		return "Videos [videoId=" + videoId + ", videoUrl=" + videoUrl + ", videoTitle=" + videoTitle + ", videoImage="
				+ videoImage + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", adminId=" + adminId
				+ ", videoDes=" + videoDes + "]";
	}
}