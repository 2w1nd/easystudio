package com.wind.util;

/**
 * @Description: 生成用户id
 * @author: w1nd
 * @date: 2021年05月03日 16:02
 */
public class UUID {
    public String getId(){
        String uuid = java.util.UUID.randomUUID().toString().replaceAll("-","");
        return uuid;
    }
}
