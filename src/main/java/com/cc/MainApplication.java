package com.cc;

import com.cc.bean.Car;
import com.cc.bean.House;
import com.cc.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@MapperScan("com.cc.mapper")
@SpringBootApplication
@Slf4j
public class MainApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MainApplication.class, args);
        String[] beanNames = context.getBeanDefinitionNames();
        for (String  beanName : beanNames) {
            System.out.println(beanName);
        }

        log.info("spring boot started!");

        boolean containsCC = context.containsBean("cc");
        System.out.println(containsCC);

        boolean containsWP = context.containsBean("wp");
        System.out.println(containsWP);

        User cc = context.getBean("cc", User.class);
        System.out.println(cc);

        Car car = context.getBean(Car.class);
        System.out.println(car);

        House house = context.getBean(House.class);
        System.out.println(house);

        System.out.println(cc.getCar() == car);
        System.out.println(cc.getHouse() == house);

        User cjy = context.getBean("cjy", User.class);
        System.out.print(cjy);
    }
}
