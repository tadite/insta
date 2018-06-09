package com.csf.insta.services;

import com.csf.insta.dao.ImageDao;
import com.csf.insta.dao.UserDao;
import com.csf.insta.dto.ImageDto;
import com.csf.insta.entities.Image;
import com.csf.insta.entities.User;
import com.csf.insta.mappers.ImageMapper;
import com.csf.insta.security.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {



    private UserDao userDao;

    private ImageDao imageDao;

    private ImageMapper imageMapper = new ImageMapper();

    @Autowired
    public ImageService(UserDao userDao, ImageDao imageDao) {
        this.userDao = userDao;
        this.imageDao = imageDao;
    }




    public ImageDto getImage(Long id) {

        Image image = imageDao.findById(id).get();
        return imageMapper.imageToImageDto(image);
    }

    public Long addImage(byte[] bytes, User user){

        Image image= new Image();
        image.setBytes(bytes);
        user = userDao.findByUsername(user.getUsername());
        image.setAuthor(user);
        image = imageDao.save(image);
        return  image.getId();

    }

    public Long addDescription(Long id, String description){
        Image image = imageDao.findById(id).get();
        image.setDescription(description);
        image = imageDao.save(image);
        return image.getId();
    }
}
