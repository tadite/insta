package com.csf.insta.controllers;

import com.csf.insta.security.CurrentUser;
import com.csf.insta.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/api")
public class ImageController {

    private ImageService imageService;  

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @RequestMapping("/description/{id}")
    public String getDescription(@PathVariable Long id){
        return imageService.getImage(id).getDescription();
    }

    @GetMapping(
            value = "/image/{id}",
            produces = MediaType.IMAGE_JPEG_VALUE
    )
    public @ResponseBody byte[] getImage(@PathVariable Long id) throws IOException {
       return imageService.getImage(id).getBytes();
    }



}
