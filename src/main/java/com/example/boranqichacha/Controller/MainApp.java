/**
 * 版权申明: 企查查科技有限公司<br>
 * 项目描述: 企查查-开放平台<br>
 * 该接口调用demo仅供学习参考
 */
package com.example.boranqichacha.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.client.methods.HttpHead;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

import static java.lang.System.out;

@RestController
@RequestMapping("/QCC/")
public class MainApp {
    // 请登录http://yjapi.com/DataCenter/MyData
    // 查看我的秘钥 我的Key
    private static final String appkey = "92325c05d8d24a3d97dac5ce908e02a9";
    private static final String seckey = "3A75A469354076788EDB7AE0606F2F49";


    /*企业工商数据查询*/
    @RequestMapping("/gssj")
    public String qichacha(String paramStr) {
        if(paramStr.length()==0){
            return "";
        }
        String reqInterNme = "http://api.qichacha.com/ECIV4/SearchWide";
        //String paramStr = "博冉";
        String status = "";
        try {
            // auth header setting
            HttpHead reqHeader = new HttpHead();
            String[] autherHeader = RandomAuthentHeader();
            reqHeader.setHeader("Token", autherHeader[0]);
            reqHeader.setHeader("Timespan", autherHeader[1]);
            out.println(autherHeader[0] + " " + autherHeader[1]);
            final String reqUri = reqInterNme.concat("?key=").concat(appkey).concat("&keyword=").concat(paramStr);
            String tokenJson = HttpHelper.httpGet(reqUri, reqHeader.getAllHeaders());
            out.println(String.format("==========================>this is response:{%s}", tokenJson));
            // parse status from json
            status = FormartJson(tokenJson, "Status");
            out.println(String.format("==========================>Status:{%s}", status));
            if (!HttpCodeRegex.isAbnornalRequest(status)) {
                PrettyPrintJson(tokenJson);
            }

            return tokenJson;
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return "";
    }

    // 获取返回码 Res Code
    static class HttpCodeRegex {
        private static final String ABNORMAL_REGIX = "(101)|(102)";
        private static final Pattern pattern = Pattern.compile(ABNORMAL_REGIX);

        protected static boolean isAbnornalRequest(final String status) {
            return pattern.matcher(status).matches();
        }
    }

    // 获取Auth Code
    protected static final String[] RandomAuthentHeader() {
        String timeSpan = String.valueOf(System.currentTimeMillis() / 1000);
        String[] authentHeaders = new String[]{DigestUtils.md5Hex(appkey.concat(timeSpan).concat(seckey)).toUpperCase(), timeSpan};
        return authentHeaders;
    }

    // 解析JSON
    protected static String FormartJson(String jsonString, String key) throws JSONException {
        JSONObject jObject = new JSONObject(jsonString);
        return (String) jObject.get(key);
    }

    // pretty print 返回值
    protected static void PrettyPrintJson(String jsonString) throws JSONException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Object obj = mapper.readValue(jsonString, Object.class);
            String indented = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
            out.println(indented);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
