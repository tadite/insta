package com.csf.insta.mappers;

import com.csf.insta.dto.ImageDto;
import com.csf.insta.entities.Image;

public class ImageMapper {

    public ImageDto imageToImageDto(Image image){
        return new ImageDto(image.getBytes(),image.getDescription());
    }

    public Image imageDtoToImage(ImageDto imageDto){
        return new Image(imageDto.getBytes(),imageDto.getDescription());
    }

}
