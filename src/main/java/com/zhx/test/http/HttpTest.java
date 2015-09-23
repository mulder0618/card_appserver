package com.zhx.test.http;

import com.zhx.base.utils.HttpRequest;

import java.io.UnsupportedEncodingException;
import  com.zhx.base.utils.MD5Util;

/**
 * Created by mulder on 2015/9/18.
 */
public class HttpTest {

    public  static void main(String[] args){
        String checkurl = "http://180.149.144.70:8081/tapi/tuan/out/cert/code/check";
        String statusurl = "http://180.149.144.70:8081/tapi/tuan/out/cert/code/status";
        String paramMd5 = MD5Util.MD5("userEmail=lalal@baidu.com&code=587611610698");
        String param="auth={\"userName\":\"lbc_test_local\",\"token\":\"9a0e839de69962df88a08b256002ab60\"}&userEmail=lalal@baidu.com&code=587611610698&sign="+paramMd5;
        long startTime=System.currentTimeMillis();
        String result = HttpRequest.sendPost(checkurl,param);
        long endTime=System.currentTimeMillis();
        try {
            System.out.println(new String(result.getBytes(), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println("耗时:" + (endTime - startTime)  + "毫秒");
    }

}
