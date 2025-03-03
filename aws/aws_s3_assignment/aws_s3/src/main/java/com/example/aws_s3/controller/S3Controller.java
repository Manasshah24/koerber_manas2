package com.example.aws_s3.controller;


import com.example.aws_s3.service.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/s3")
@RequiredArgsConstructor
public class S3Controller {

    private final S3Service s3Service;

    @PostMapping("/create-bucket/{bucketName}")
    public ResponseEntity<String> createBucket(@PathVariable String bucketName) {
        return ResponseEntity.ok(s3Service.createBucket(bucketName));
    }

    @DeleteMapping("/delete-bucket/{bucketName}")
    public ResponseEntity<String> deleteBucket(@PathVariable String bucketName) {
        return ResponseEntity.ok(s3Service.deleteBucket(bucketName));
    }

    @PostMapping("/upload/{bucketName}")
    public ResponseEntity<String> uploadFile(@PathVariable String bucketName,
                                             @RequestParam("file") MultipartFile file) throws IOException {
        return ResponseEntity.ok(s3Service.uploadFile(bucketName, file.getOriginalFilename(), file));
    }

    @DeleteMapping("/delete-file/{bucketName}/{fileName}")
    public ResponseEntity<String> deleteFile(@PathVariable String bucketName, @PathVariable String fileName) {
        return ResponseEntity.ok(s3Service.deleteFile(bucketName, fileName));
    }
}

