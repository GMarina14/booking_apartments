package com.example.booking_apartments.service.impl;

import com.example.booking_apartments.model.entity.Image;
import com.example.booking_apartments.repository.ImageRepository;
import com.example.booking_apartments.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private Logger log = LoggerFactory.getLogger(ImageServiceImpl.class);
    private final ImageRepository imageRepository;

    @Override
    public Image saveToDb(MultipartFile multipartFile) throws IOException {
        log.info("IntegrationServiceImpl : ImageServiceImpl -> saveToDb");

        Image image = new Image();
        try {
            image.setImage(multipartFile.getBytes());
        } catch (IOException e) {
            log.error("ImageServiceImpl: saveToDb: 'multipartFile' IOException");
        }

        log.info("IntegrationServiceImpl : ImageServiceImpl <- saveToDo");
        return imageRepository.save(image);
    }

    @Override
    public byte[] getById(Long id) {
        log.info("IntegrationServiceImpl : ImageServiceImpl ->getById");

        Image imageById = imageRepository.findImageById(id);

        log.info("IntegrationServiceImpl : ImageServiceImpl <- getById");
        return imageById.getImage();
    }

    @Service
    @RequiredArgsConstructor
    public static class IntegrationServiceImpl {

        // dfcb67fbb3b74d3b8c01dba2a3ecefe0


    }
}
