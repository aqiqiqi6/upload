package com.coderqi.aliyunupload.controller;

import com.coderqi.aliyunupload.eneity.FileRecord;
import com.coderqi.aliyunupload.service.AliyunOssService;
import com.coderqi.aliyunupload.service.FileRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/upload")
public class FileUploadController {
    @Autowired
    private AliyunOssService aliyunOssService;

    @Autowired
    private FileRecordService fileRecordService;

    /**
     * 上传文件
     */
    @PostMapping
    public Map<String, Object> uploadFile(@RequestParam("file") MultipartFile file) {
        Map<String, Object> result = new HashMap<>();

        // 上传文件到 OSS
        String fileUrl = aliyunOssService.uploadFile(file);
        if (fileUrl == null) {
            result.put("status", "fail");
            result.put("message", "文件上传失败");
            return result;
        }

        // 保存文件信息到数据库
        FileRecord fileRecord = new FileRecord();
        fileRecord.setFileName(file.getOriginalFilename());
        fileRecord.setFileUrl(fileUrl);
        fileRecord.setUploadTime(LocalDateTime.now());
        fileRecordService.save(fileRecord);

        result.put("status", "success");
        result.put("fileUrl", fileUrl);
        return result;
    }
}
