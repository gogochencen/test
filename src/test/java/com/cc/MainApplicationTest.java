package com.cc;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cc.bean.City;
import com.cc.service.CityService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MainApplicationTest {

    @Autowired
    private CityService cityService;

    @Test
    @DisplayName("城市列表测试")
    public void list() {
        List<City> cityList = this.cityService.list();
        Assertions.assertNotNull(cityList);
    }

    @Test
    @DisplayName("城市分页测试")
    public void page() {
        Page<City> cityList = this.cityService.page(new Page<>(1,1));
        Assertions.assertNotNull(cityList);
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("before each1");
    }

    @AfterEach
    void afterEach(){
        System.out.println("after each");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("before all");
    }


    @AfterAll
    static void afterAll() {
        System.out.println("after all");
    }

    @Test
    public void testVersion(){
        City city = this.cityService.getById(1);
        city.setCityName("HangZhou");
        boolean result = this.cityService.saveOrUpdate(city);
        Assertions.assertTrue(result);
    }

    @Test
    public void testLogicDelete(){
        City city = new City();
        city.setProvince("广东");
        city.setCityName("深圳");
        boolean result = cityService.save(city);
        Assertions.assertTrue(result);

        boolean deleted = this.cityService.removeById(city.getId());
        Assertions.assertTrue(deleted);

    }
}
