package com.csf.insta.dto;

import java.util.List;

public class ProfileDto {

    private List<Long> imageIds;

    private ProfileDataDto profileData;

    public ProfileDto(List<Long> imageIds, ProfileDataDto profileData) {
        this.imageIds = imageIds;
        this.profileData = profileData;
    }

    public List<Long> getImageIds() {
        return imageIds;
    }

    public void setImageIds(List<Long> imageIds) {
        this.imageIds = imageIds;
    }

    public ProfileDataDto getProfileData() {
        return profileData;
    }

    public void setProfileData(ProfileDataDto profileData) {
        this.profileData = profileData;
    }
}
