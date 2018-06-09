package com.csf.insta.mappers;

import com.csf.insta.dto.ProfileDataDto;
import com.csf.insta.dto.ProfileDto;
import com.csf.insta.entities.Image;
import com.csf.insta.entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    public ProfileDto userToProfileDto(User user){
        List<Long> imagesids = new ArrayList<>();
        for (Image image:user.getImages()) {
            imagesids.add(image.getId());
        }
        return new ProfileDto(imagesids,new ProfileDataDto(
                user.getUsername(),user.getFirstName()+" "+ user.getLastName(),user.getInfo()));
    }



}
