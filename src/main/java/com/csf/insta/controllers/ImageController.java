package com.csf.insta.controllers;

import com.csf.insta.entities.User;
import com.csf.insta.security.CurrentUser;
import com.csf.insta.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.codec.Utf8;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

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
            value = "/image/{id}"
            //produces = MediaType.BA
    )
    public @ResponseBody byte[] getImage(@PathVariable Long id) throws IOException {
       return imageService.getImage(id).getBytes();
    }

    @RequestMapping(value = "/image", //
            method = RequestMethod.POST)
    @ResponseBody
    public Long addImage(@CurrentUser User user, @RequestBody String base64) throws IOException {

        return imageService.addImage(base64.getBytes(),user);
    }

    @RequestMapping(
            value = "/image/{id}",
            method = RequestMethod.POST
    )
    public @ResponseBody Long addDescription(@PathVariable Long id, @RequestBody String description) throws IOException {
        return imageService.addDescription(id,description);
    }


}
