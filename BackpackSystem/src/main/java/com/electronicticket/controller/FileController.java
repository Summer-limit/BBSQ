package com.electronicticket.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.websocket.server.PathParam;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;

/**
 * @author Niubaiquan
 * @desc 文件上传
 * @date 2022年05月15日 2022/5/15
 */
@Slf4j
@Controller
public class FileController {
    @PostMapping("load")
    public String up_load(@RequestParam("name") String name,
                          @RequestParam("email") String email,
                          @RequestPart("headImg") MultipartFile headImg,
                          @RequestPart("photos") MultipartFile[] photos) throws IOException {
        log.info("name={},email={},头像大小为{},生活照数量为{}",name,email,headImg.getSize(),photos.length);
        if (headImg.isEmpty()) {
            headImg.transferTo(new File("F://springboot//file//headImg//"+headImg.getOriginalFilename()));
        }
        //保存文件数组
        Iterator<MultipartFile> iterator = Arrays.stream(photos).iterator();
        while (iterator.hasNext()){
            MultipartFile file=iterator.next();
            if (file.isEmpty()) {
                file.transferTo(new File("F://springboot//file//photos//"+file.getOriginalFilename()));
            }
        }

        return "succeed";
    };
}
