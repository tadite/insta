package com.csf.insta.services;

import com.csf.insta.dao.ImageDao;
import com.csf.insta.dto.ImageDto;
import com.csf.insta.entities.Image;
import com.csf.insta.mappers.ImageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

    private ImageDao imageDao;

    private ImageMapper imageMapper = new ImageMapper();

    @Autowired
    public ImageService(ImageDao imageDao) {
        this.imageDao = imageDao;
    }

    public ImageDto getImage(Long id) {

        Image image = imageDao.findById(id).get();
        return imageMapper.imageToImageDto(image);
    }
}
