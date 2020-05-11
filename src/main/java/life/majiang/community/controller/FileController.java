package life.majiang.community.controller;

import life.majiang.community.dto.FileDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;

public class FileController {
    //这里autowire对应的云存储的provider
    @RequestMapping("/file/upload")
    @ResponseBody
    public FileDTO upload(HttpServletRequest request) {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = multipartRequest.getFile("editormd-image-file");
//        try{
//            //provider加载(图片流，图片名称，图片类型)
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        FileDTO fileDTO = new FileDTO();
        fileDTO.setSuccess(1);
        fileDTO.setUrl("/image/leetcode contest.jpg");
        return fileDTO;
    }
}
