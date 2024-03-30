package com.cc.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cc.bean.City;
import com.cc.mapper.CityMapper;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl extends ServiceImpl<CityMapper, City> implements CityService{
    // 实现类代码
}
