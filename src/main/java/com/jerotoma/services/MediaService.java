package com.jerotoma.services;

import java.util.List;

import com.jerotoma.model.Media;

public interface MediaService {
	public List<Media> media();
	public Media getMedia(int id);
	public boolean delete(Media media);
	public int save(Media media);
	public int update(Media media);
}
