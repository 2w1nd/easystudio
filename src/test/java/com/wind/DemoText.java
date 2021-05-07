package com.wind;

import java.util.UUID;

/**
 * @Description: 测试类
 * @author: w1nd
 * @date: 2021年05月03日 15:56
 */
public class DemoText {
    public static void main(String[] args) {
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        System.out.println(uuid);
    }
}
