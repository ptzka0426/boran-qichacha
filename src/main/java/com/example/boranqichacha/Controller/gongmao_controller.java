package com.example.boranqichacha.Controller;


import com.example.boranqichacha.Entity.Person;
import com.example.boranqichacha.Util.*;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.System.out;

/**
 * @Author LT
 * @create 2021-04-21 9:56
 */
@CrossOrigin()
@RequestMapping("/gongmao")
@RestController
public class gongmao_controller {

    /*身份信息上传*/
    @ResponseBody
    @RequestMapping("/api/attachment/uploadIndentityFile")
    public AjaxJson Upload_of_identity_information(@RequestParam Map<String, Object> map, @RequestParam("file") MultipartFile[] file) throws Exception {
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
        String tokenJson = HttpsUtils.post("https://openapi-qa.gongmall.com/api/attachment/uploadIndentityFile", map);

        return AjaxJson.getSuccess(tokenJson);
    }

    @ResponseBody
    @RequestMapping("/api/employee/syncInfo")
    public  AjaxJson Identity_information_synchronization(@RequestParam Map<String, Object> map) throws Exception {
        map.put("appKey", "c3ce6bdda9c34120bef5477ac54c38c3");
        map.put("nonce", new Random().nextInt(100000) + "");
        map.put("timestamp", Calendar.getInstance().getTimeInMillis() + "");
        String appSecret = "946ba81891aa09380e3012ce7eb2ee35";
        //生成签名
        String token = SignUtil.getSign(map, appSecret);
        map.put("sign", token);
        String bodys = SignUtil.getUrlText(map);
        out.println(bodys);
        String tokenJson = HttpsUtils.post("https://openapi-qa.gongmall.com/api/employee/syncInfo", map);

        return AjaxJson.getSuccess(tokenJson);
    }
/*    appKey
60b5f65ef29f4fb29dfe32d80d629f87
            appSecret
    ffceccfd170345ef4a25b69cbad256c2
            合同地址
    https://contract.gongmall.com/url_contract.html?companyId=zD3g1M&positionId=VBJBkV*/
    /*h5加密*/
    @ResponseBody
    @RequestMapping(value = "/api/aes",method = RequestMethod.POST)
    public AjaxJson testAes(@RequestParam Map<String, Object> map) throws Exception {
        /*String appKey = "60b5f65ef29f4fb29dfe32d80d629f87";
        String appSecret = "ffceccfd170345ef4a25b69cbad256c2";*/
        /*appKey+appSecret*/
        String md5= DigestUtils.md5Hex("60b5f65ef29f4fb29dfe32d80d629f87"+"ffceccfd170345ef4a25b69cbad256c2").toUpperCase();
        String bodys = SignUtil.getUrlText(map);
        return AjaxJson.getSuccess( " https://contract.gongmall.com/url_contract.html?companyId=zD3g1M&positionId=VBJBkV"+"&data="+AESEncryptUtil.aesEncrypt(bodys,md5));
    }

    @Autowired
    Person Person;

    @RequestMapping("/test")
    AjaxJson test() {
        return AjaxJson.getSuccess(Person.getLastName(), Person.getLt());
    }


    public static void main(String[] args) {
        String[] strs = {"java8", "is", "easy", "to", "use"};
        List<String> distinctStrs = Arrays.stream(strs)
                .map(str -> str.split(""))  // 映射成为Stream<String[]>
                .flatMap(Arrays::stream)  // 扁平化为Stream<String>
                .distinct()
                .collect(Collectors.toList());
        distinctStrs.forEach(s->{
            out.println(s);
        });
    }
}
