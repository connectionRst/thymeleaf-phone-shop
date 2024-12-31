package com.common.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class FileUtils {

    public static String renameFile(MultipartFile file) {
        //原文件名
        String name = file.getOriginalFilename();
        //后缀
        String suffixName = name.substring(name.lastIndexOf("."));
        //新文件名
        name = UUID.randomUUID() + suffixName;
        return name;
    }

    public static boolean transferToFile(MultipartFile file, String savePath) {
        File saveFile = new File(savePath);
        if (!saveFile.exists()) {
            saveFile.mkdirs();
        }
        try {
            file.transferTo(saveFile);  //将临时存储的文件移动到真实存储路径下
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
