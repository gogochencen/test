package com.cc.bean;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User {

    private String name;

    private Integer age;

    private Car car;

    private House house;
}
