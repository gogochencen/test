package com.cc.bean;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@TableName("city_of_china")
public class City {

    @TableId(type = IdType.AUTO)
    private Integer id;

    // 省份
    private String province;

    // 城市
    private String cityName;

    @Version
    private Integer version;

    @TableLogic
    private Integer isDeleted;

}
