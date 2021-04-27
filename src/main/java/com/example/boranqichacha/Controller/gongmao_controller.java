package com.example.boranqichacha.Controller;

import com.example.boranqichacha.Util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

import static java.lang.System.out;

/**
 * @Author LT
 * @create 2021-04-21 9:56
 */
@RequestMapping("gongmao")
@RestController
public class gongmao_controller {

    @ResponseBody
    @RequestMapping("/api/attachment/uploadIndentityFile")
    public AjaxJson test(@RequestParam Map<String, Object> map, @RequestParam("file") MultipartFile[] file) throws Exception {
        map.put("appKey", "c3ce6bdda9c34120bef5477ac54c38c3");
        map.put("nonce", new Random().nextInt(100000) + "");
        map.put("timestamp", Calendar.getInstance().getTimeInMillis() + "");

        /*for (MultipartFile files : file){*/
        map.put("identityFrontBase64", MultipartFile_ImageToBase64.generateBase64(file[0]));
        map.put("identityBackgroundBase64", MultipartFile_ImageToBase64.generateBase64(file[1]));
        /* }*/

        String appSecret = "946ba81891aa09380e3012ce7eb2ee35";
        //生成签名
        String token = SignUtil.getSign(map, appSecret);
        map.put("sign", token);
        String bodys = SignUtil.getUrlText(map);
        out.println(bodys);
        String tokenJson= HttpsUtils.post("https://openapi-qa.gongmall.com/api/attachment/uploadIndentityFile",map);

        return AjaxJson.getSuccess(tokenJson);
    }
    
    @Autowired
    com.example.boranqichacha.Entity.Person Person;
    @RequestMapping("/test")
    AjaxJson test(){
        return AjaxJson.getSuccess(Person.getLastName(),Person.getLt());
    }
}
