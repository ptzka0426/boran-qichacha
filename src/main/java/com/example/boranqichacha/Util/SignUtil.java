package com.example.boranqichacha.Util;

import org.apache.commons.codec.digest.DigestUtils;

import java.net.URLEncoder;
import java.util.*;


/**
 * @Author LT
 * @create 2021-04-20 16:59
 */
public class SignUtil {
    /* public static void main(String[] args) {
         System.out.println(new Random().nextInt(100000));
         Calendar calendar=Calendar.getInstance();
         System.out.println(calendar.getTimeInMillis());
     }*/
    /* 正式环境
    appKey
    644891ced71945c487e4f46c8bf4dafb
    appSecret
    365c27747c74a504d33ccee1d2e808b6
    合同地址（用于H5对接）
    https://contract.gongmall.com/url_contract.html?companyId=PjaNNV&positionId=zKBynM

    测试环境
    appKey
    c3ce6bdda9c34120bef5477ac54c38c3
    appSecret
    946ba81891aa09380e3012ce7eb2ee35
    合同地址（用于H5对接）
    https://contract-qa.gongmall.com/url_contract.html?companyId=zyXpGM&positionId=bVBGwP

    正式环境：
    账户：安阳市华萌信息科技有限公司
    卡号：5719145951109020000000036
    开户行：开户行：招商银行 高教路支行 杭州
    测试环境：已充值，可测试提现*/
    public static final String APPKEY = "644891ced71945c487e4f46c8bf4dafb";
    public static final String APPSECRET = "365c27747c74a504d33ccee1d2e808b6";
    public static final String NONCE = new Random().nextInt(100000) + "";
    public static final String TIMESTAMP = Calendar.getInstance().getTimeInMillis() + "";
    public static final String SIGN = "sign";

    /**
     * 获取签名
     *
     * @param paramMap  包含所有业务参数，和appKey,nonce,timestamp这3个公共参数
     * @param appSecret
     * @return
     */
    public static String getSign(Map<String, Object> paramMap, String appSecret) throws Exception{
        String text;
        text = getUrlText(paramMap);
        text += "&appSecret=" + appSecret;
        System.out.println(text);
        //返回加密，转大写
        return DigestUtils.md5Hex(text).toUpperCase();
    }

    public static String getUrlText(Map<String, Object> beanMap) throws Exception{
        beanMap = getSortedMap(beanMap);
        StringBuilder builder = new StringBuilder();
        for (String key : beanMap.keySet()) {
            String value = beanMap.get(key).toString();
            builder.append(key);
            builder.append('=');
            builder.append(value);
            builder.append('&');
        }
        String text = builder.toString();
        return text.substring(0, text.length() - 1);
    }

    /**
     * 对普通map进行排序
     *
     * @param paramMap
     * @return
     */
    public static Map<String, Object> getSortedMap(Map<String, Object> paramMap)throws Exception {
        SortedMap<String, Object> map = new TreeMap<String, Object>();
        for (String key : paramMap.keySet()) {
            if (key != null && !APPSECRET.equals(key)) {
                Object value = paramMap.get(key);
                if (value != null) {
                    String valueStr = String.valueOf(value);
                    if (valueStr != null && !"".equals(valueStr)) {
                        map.put(key, value.toString());
                    }
                }
            }
        }
        return map;
    }
}
