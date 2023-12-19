package com.fairytale.server.controller.storage;

import com.fairytale.server.service.storage.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;

@RestController
@RequestMapping("/server/storage")
public class FileUploadController {

    private final FileStorageService fileStorageService;

    @Autowired
    public FileUploadController(FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(
            @RequestParam("file") MultipartFile file,
            @RequestParam("userName") String userName) {
        try {
            System.out.println("userName : "+ userName);
            String filePath = "book/" + userName + "/" + file.getOriginalFilename();
            String downloadUrl = fileStorageService.uploadFile(file, filePath);
            return ResponseEntity.ok(Collections.singletonMap("downloadUrl", downloadUrl));
        } catch (RuntimeException e) {
            // 예외 처리 로직
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File upload failed: " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/profile")
    public ResponseEntity<?> profileFile(
            @RequestParam("file") MultipartFile file,
            @RequestParam("userName") String userName) {
        try {
            System.out.println("userName : " + userName);
            String filePath = "profile/" + userName + "/" + file.getOriginalFilename();
            String downloadUrl = fileStorageService.profileFile(file, filePath);
            return ResponseEntity.ok(Collections.singletonMap("downloadUrl", downloadUrl));
        } catch (RuntimeException e) {
            // 예외 처리 로직
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File upload failed: " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

