package com.example.dubbo.provider.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.dubbo.provider.CityDubboService;
import com.example.entity.City;

/**
 * 城市业务 Dubbo 服务层实现层
 *
 * Created by bysocket on 28/02/2017.
 */
// 注册为 Dubbo 服务
@Service(version = "1.1.0")
public class CityDubboServiceImpl implements CityDubboService {

    public City findCityByName(String cityName) {
        return new City(1,"GZ","温岭","是我的故乡");
    }
}
