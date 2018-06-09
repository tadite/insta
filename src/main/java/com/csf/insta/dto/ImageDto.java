package com.csf.insta.dto;

public class ImageDto {
    private byte[] bytes;

    private String description;

    public ImageDto(byte[] bytes, String description) {
        this.bytes = bytes;
        this.description = description;
    }



    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
