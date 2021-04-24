package com.example.boranqichacha.Controller;

import com.example.boranqichacha.Util.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.client.methods.HttpHead;
import org.json.HTTP;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
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
    public AjaxJson test(@RequestParam Map<String, Object> map) throws Exception {
        map.put("appKey", "c3ce6bdda9c34120bef5477ac54c38c3");
        map.put("nonce", new Random().nextInt(100000) + "");
        map.put("timestamp", Calendar.getInstance().getTimeInMillis() + "");
        /*System.out.println(map);*/
        String appSecret = "946ba81891aa09380e3012ce7eb2ee35";
        //生成签名
        String token = SignUtil.getSign(map, appSecret);
        map.put("sign", token);
        String bodys = SignUtil.getUrlText(map);
        out.println(bodys);
        //String tokenJson = HttpRequestUtil.httpRequest("https://openapi-qa.gongmall.com/api/attachment/uploadIndentityFile", "POST",bodys);
        String tokenJson= HttpsUtils.post("https://openapi-qa.gongmall.com/api/attachment/uploadIndentityFile",map);
        //String tokenJson=  HttpUtil.post("http://10.100.64.22/api/similarity/v1/", param.toString());
        return AjaxJson.getSuccess(tokenJson);
    }
}
