package com.zhx.base.utils;

import java.util.LinkedHashMap;

/**
 * Created by mulder on 2015/9/23.
 */
public class SignUtil {

    /**
     * �ж�ǩ���Ƿ�Ϸ�
     * @param params
     * @return
     */
    public static boolean  checkSign(LinkedHashMap... params){
        for (LinkedHashMap param : params){
            System.out.println(param);
        }
        return  true;
    }



    public static void main(String[] args){

    }
}
