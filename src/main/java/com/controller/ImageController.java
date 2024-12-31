package com.controller;

import com.common.utils.FileUtils;
import com.pojo.result.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.logging.Logger;

@RestController
@RequestMapping("/image")
public class ImageController {


    @PostMapping("/upload")
    public Result uploadImg(@RequestParam(value = "file") MultipartFile file, @RequestParam(value = "type") String type) throws IOException {
        String basePath = "";
        if (System.getProperty("os.name").toLowerCase().startsWith("win")) {
            basePath = System.getProperty("user.dir") + "/src/main/resources/static/";
        } else {
            basePath = System.getProperty("user.dir") + "/img/";
        }
        //自定义路径
        String urlPath = String.format("/images/%s/%s", type, FileUtils.renameFile(file));
        //图片保存路径
        String savePath = basePath + urlPath;
        if (FileUtils.transferToFile(file,savePath)) {
            return Result.success(urlPath);
        } else {
            return Result.failure();
        }
    }

    @RequestMapping("/excel")
    public Result uploadExcel(@RequestParam(value = "file") MultipartFile file) {
        return Result.success();
    }
}
