package com.example.dao;

import com.example.entity.City;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface MongoCityDao extends MongoRepository<City, String> {

    @Query("")
    City findCityByCityName(String cityName);

}