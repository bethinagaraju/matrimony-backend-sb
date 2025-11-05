package com.example.demo.controller;

import com.example.demo.entity.UserProfile;
import com.example.demo.repository.UserProfileRepository;
import com.example.demo.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/user")
public class UserProfileController {

    @Autowired
    private ImageService imageService;

    @Autowired
    private UserProfileRepository userProfileRepository;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadUserImage(
            @RequestParam("name") String name,
            @RequestParam("image") MultipartFile image) {

        try {
            String imagePath = imageService.saveImage(image);

            UserProfile user = new UserProfile();
            user.setName(name);
            user.setImagePath(imagePath);

            userProfileRepository.save(user);

            return ResponseEntity.ok("Image uploaded successfully! URL Path: " + imagePath);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error: " + e.getMessage());
        }
    }
}
