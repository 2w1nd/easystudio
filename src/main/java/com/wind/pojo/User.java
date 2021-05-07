package com.wind.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String id;  // 用户id

    private String username; // 用户名

    private String password; // 用户密码

    private String email; // 用户邮箱
}
