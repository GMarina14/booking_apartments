package com.example.booking_apartments.service;

import org.springframework.web.multipart.MultipartFile;
import com.example.booking_apartments.model.entity.Image;

import java.io.IOException;

public interface ImageService {

    Image saveToDb(MultipartFile multipartFile) throws IOException;

    byte[] getById(Long id);
}
