// package com.example.demo.service;

// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.stereotype.Service;
// import org.springframework.web.multipart.MultipartFile;

// import java.io.IOException;
// import java.nio.file.Files;
// import java.nio.file.Path;
// import java.nio.file.Paths;
// import java.nio.file.StandardCopyOption;

// @Service
// public class ImageService {

//     @Value("${file.upload-dir}")
//     private String uploadDir;

//     @Value("${file.base-url}")
//     private String baseUrl;

//     public String saveImage(MultipartFile file) throws IOException {
//         if (file.isEmpty()) {
//             throw new IOException("File is empty");
//         }

//         // Save as timestamp + original filename
//         String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
//         Path filePath = Paths.get(uploadDir, fileName);

//         // Create directory if it doesn't exist
//         Files.createDirectories(filePath.getParent());

//         // Save file on server
//         Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

//         // Return full public URL
//         return baseUrl + fileName;
//     }
// }


package com.example.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class ImageService {

    @Value("${file.upload-dir}")
    private String uploadDir;

    private final String BASE_URL = "https://images.bandhammatrimony.com/";

    public String saveImage(MultipartFile file) throws IOException {

        if (file.isEmpty()) {
            throw new IOException("File is empty");
        }

        // Save file as employeeID or time-based
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        Path uploadPath = Paths.get(uploadDir);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        Path filePath = uploadPath.resolve(fileName);
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        // Return public URL
        return BASE_URL + fileName;
    }
}
