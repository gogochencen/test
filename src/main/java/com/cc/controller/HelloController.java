package com.cc.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cc.bean.Account;
import com.cc.bean.Car;
import com.cc.bean.City;
import com.cc.mapper.AccountMapper;
import com.cc.service.CityService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RestController
public class HelloController {

    @Autowired
    private Car car;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private CityService cityService;

    @RequestMapping("hello")
    public String hello() {
        return "Hello, SpringBoot2!";
    }

    @RequestMapping("car")
    public String car() {
        log.info("receive req my car");
        return car.toString();
    }

    @RequestMapping("account")
    public List<String> account() {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from account");
        if (CollectionUtils.isNotEmpty(list)) {
            // 返回账户信息
            return list.stream().map(map -> map.get("name").toString()).collect(Collectors.toList());
        }
        return Lists.newArrayList();
    }

    @RequestMapping("findAll")
    public List<Account> findAll() {
        return accountMapper.findAll();
    }

    @RequestMapping("findById")
    public Account findById(@RequestParam("id") Integer id) {
        return accountMapper.findById(id);
    }

    @RequestMapping("selectById")
    public Account selectById(@RequestParam("id") Integer id) {
        return accountMapper.selectById(id);
    }

    @RequestMapping("listCity")
    public List<City> listCity(){
        return cityService.list();
    }

    @RequestMapping("pageCity")
    public Page<City> pageCity(@RequestParam(value = "page", defaultValue = "1") Integer page){
        return cityService.page(new Page<>(page,2));
    }
}
