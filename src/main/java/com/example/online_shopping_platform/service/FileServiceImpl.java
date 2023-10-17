package com.example.online_shopping_platform.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService{
    @Override
    public String handlerFormUpload(MultipartFile file) {
        //判断上传文件是否存在
        if(!file.isEmpty()) {
            //获取上传文件原始名称
            String originalFilename = file.getOriginalFilename();
            //设置上传文件保存地址目录
            //String dirPath = request.getServletContext().getRealPath("/picture/");
            String dirPath = "E:/picture/";
            File filePath = new File(dirPath);
            //如果保存文件的地址不存在，则创建地址
            if (!filePath.exists()) {
                filePath.mkdirs();
            }
            //使用UUID命名文件+文件原始名称
            String newFilename =UUID.randomUUID() + "_" + originalFilename;
            try {
                //使用MultipartFile接口的方法完成文件上传到指定位置；
                file.transferTo(new File(dirPath + newFilename));
            } catch (IllegalStateException | IOException e) {
                e.printStackTrace();
            }
            return dirPath + newFilename;
        }
        else {
            return "E:/picture/123.png";
        }
    }

}
