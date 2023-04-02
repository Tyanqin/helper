package com.zxt.helper.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

/**
 * @author:TanXiao
 * @date:2023/4/2
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpLoadParam implements Serializable {
    private String regName;
    private MultipartFile file;
}
