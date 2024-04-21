package com.cc.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.cc.bean.Car;
import com.cc.bean.House;
import com.cc.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@EnableConfigurationProperties(Car.class)
@Import(House.class)
@ImportResource("classpath:beans.xml")
public class MyConfig {

    @Autowired
    private Car car;

    @Autowired
    private House house;

    @Bean
    public User wp(){
        User user = new User();
        user.setName("wp");
        user.setAge(18);
        user.setCar(car);
        user.setHouse(house);
        return user;
    }

    @Bean
    @ConditionalOnBean(name="wp")
    public User cc() {
        User user = new User();
        user.setName("cc");
        user.setAge(18);
        user.setCar(car);
        user.setHouse(house);
        return user;
    }

    @Bean
    public MybatisPlusInterceptor paginationInterceptor() {
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor();
        paginationInnerInterceptor.setOverflow(true);
        paginationInnerInterceptor.setMaxLimit(100L);
        mybatisPlusInterceptor.addInnerInterceptor(paginationInnerInterceptor);
        return mybatisPlusInterceptor;
    }


}
