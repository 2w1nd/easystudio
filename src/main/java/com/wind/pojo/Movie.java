package com.wind.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:
 * @author: w1nd
 * @date: 2021年05月02日 12:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    private String id;      // 电影id

    private String name;  // 电影名字

    private String url; // 电影位置

    private String years; // 上映时间

    private String image; // 电影封面位置

    private String poster; // 电影海报位置
}
