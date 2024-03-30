package com.cc.bean;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "mycar")
@Data
@ToString
public class Car {

    private String brand;

    private Long price;

}
