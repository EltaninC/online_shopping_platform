package com.example.online_shopping_platform.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    String handlerFormUpload(MultipartFile file);
}
