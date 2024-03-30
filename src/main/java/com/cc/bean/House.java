package com.cc.bean;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class House {

    private String address;

    private Integer size;

    private Integer floor;

    public House() {
        this.address = "杭州拱墅区祥符街道融信学院府16-1-503";
        this.size = 89;
        this.floor = 5;
    }
}
