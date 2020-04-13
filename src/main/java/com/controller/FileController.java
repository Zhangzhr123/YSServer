package com.controller;

import com.bean.Result;
import com.utils.Common;
import com.utils.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
/*
* 文件下载url
* 192.168.0.123:26590/file/download
*filename  下载的文件名
* */
@Controller
@RequestMapping("file")
public class FileController {

    private final ResourceLoader resourceLoader;

    @Autowired
    public FileController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @RequestMapping("/{filename:.+}")
    public ResponseEntity<?> getFile1(@PathVariable String filename) {

        try {
            return ResponseEntity.ok(resourceLoader.getResource("file:" + Common.UP_LOAD_PATH + filename));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping("getfile")
    public ResponseEntity<?> getFile(String filepath) {
        try {
            String filename = filepath.substring(filepath.lastIndexOf("/") + 1);

            return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                    "attachment; filename=" + filename).body(resourceLoader.getResource("file:" + Common.UP_LOAD_PATH + filepath));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping("download")
    public String downLoad(HttpServletResponse response){

        File file = new File("E:/gptraing.apk");
        String filename = "gptraing.apk";
        if(file.exists()){ //判断文件父目录是否存在
            response.setContentType("application/force-download");
            response.setHeader("Content-Disposition", "attachment;fileName=" + filename);

            byte[] buffer = new byte[1024];
            FileInputStream fis = null; //文件输入流
            BufferedInputStream bis = null;

            OutputStream os = null; //输出流
            try {
                os = response.getOutputStream();
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                int i = bis.read(buffer);
                while(i != -1){
                    os.write(buffer);
                    i = bis.read(buffer);
                }

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("----------file download" + filename);
            try {
                bis.close();
                fis.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return null;
    }

    @ResponseBody
    @RequestMapping("uploadproject")
    public Result<String> file(@RequestParam(value = "file", required = true) MultipartFile file, HttpSession session){

        Result<String> res = UploadUtil.uploadProject(file);
        return res;
    }



}
