package com.example.boranqichacha.Util;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import org.apache.commons.codec.binary.Base64;
/**
 * @Author LT
 * @create 2021-04-24 10:41
 * 图片转化base64
 */
public class MultipartFile_ImageToBase64 {
    /**
     * 将MultipartFile 图片文件编码为base64
     * @param file
     * @return
     * @throws Exception
     */
    public static String generateBase64(MultipartFile file){
        if (file == null || file.isEmpty()) {
            throw new RuntimeException("图片不能为空！");
        }
        String fileName = file.getOriginalFilename();
        String fileType = fileName.substring(fileName.lastIndexOf("."));
        String contentType = file.getContentType();
        byte[] imageBytes = null;
        String base64EncoderImg="";
        try {
            imageBytes = file.getBytes();
                //Base64 base64Encoder =new Base64();

            /**
             * 1.Java使用BASE64Encoder 需要添加图片头（"data:" + contentType + ";base64,"），
             *   其中contentType是文件的内容格式。
             * 2.Java中在使用BASE64Enconder().encode()会出现字符串换行问题，这是因为RFC 822中规定，
             *   每72个字符中加一个换行符号，这样会造成在使用base64字符串时出现问题，
             *   所以我们在使用时要先用replaceAll("[\\s*\t\n\r]", "")解决换行的问题。
             */
            base64EncoderImg = "data:" + contentType + ";base64," + Base64.encodeBase64String(imageBytes);
            base64EncoderImg = base64EncoderImg.replaceAll("[\\s*\t\n\r]", "");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return base64EncoderImg;
    }
}
