package com.coderqi.aliyunupload.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coderqi.aliyunupload.eneity.FileRecord;
import com.coderqi.aliyunupload.mapper.FileRecordMapper;
import com.coderqi.aliyunupload.service.FileRecordService;
import org.springframework.stereotype.Service;

@Service
public class FileRecordServiceImpl extends ServiceImpl<FileRecordMapper, FileRecord> implements FileRecordService {
}
