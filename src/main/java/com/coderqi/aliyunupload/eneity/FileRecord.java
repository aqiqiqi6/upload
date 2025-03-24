package com.coderqi.aliyunupload.eneity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("file_record")
public class FileRecord {
    @TableId
    private Long id;
    private String fileName;
    private String fileUrl;
    private LocalDateTime uploadTime;
}
