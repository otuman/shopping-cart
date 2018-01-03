package com.jerotoma.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jerotoma.dao.MediaDao;
import com.jerotoma.model.Media;
import com.jerotoma.services.MediaService;

@Service
@Transactional
public class MediaServiceImplementation implements MediaService{

	@Autowired
	 MediaDao mediaDao;
	
	public List<Media> media() {
		// TODO Auto-generated method stub
		return mediaDao.media();
	}

	public Media getMedia(int id) {
		// TODO Auto-generated method stub
		return mediaDao.getMedia(id);
	}

	public boolean delete(Media media) {
		// TODO Auto-generated method stub
		return mediaDao.delete(media);
	}

	public int save(Media media) {
		// TODO Auto-generated method stub
		return mediaDao.save(media);
	}

	public int update(Media media) {
		// TODO Auto-generated method stub
		return mediaDao.update(media);
	}

}
