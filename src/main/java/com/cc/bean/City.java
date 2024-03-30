package com.cc.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@TableName("city_of_china")
public class City {

    private Integer id;

    // 省份
    private String province;

    // 城市
    private String cityName;


}
