package com.example.service.impl;

import com.example.controller.MyRestController;
import com.example.dao.CityDao;

import com.example.entity.City;
import com.example.entity.Mobile;
import com.example.service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityDao cityDao;

    private static Logger logger = LoggerFactory.getLogger(MyRestController.class);
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public City findCityByName(String cityName) {
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        operations.set("myjob3","myjob3-12312");

        String aa = (String) operations.get("myjob2");
        System.out.println("aa="+aa);

        aa = (String) operations.get("myjob3");
        System.out.println("aa="+aa);

        City city = cityDao.findByName(cityName);

        String tempTableName ="tmp_extract_a";
        List<Mobile> mobileList = cityDao.findByStoreProc2(tempTableName);
        for (Mobile mobile :mobileList)
        {
            logger.info("mobile="+mobile.getMobileNumber());
        }
        return city;
    }
}
