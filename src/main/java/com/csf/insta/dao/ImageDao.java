package com.csf.insta.dao;

import com.csf.insta.entities.Image;
import org.springframework.data.repository.CrudRepository;

public interface ImageDao extends CrudRepository<Image,Long> {
}
