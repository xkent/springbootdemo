package com.example.dao;


import com.example.entity.City;
import com.example.entity.Mobile;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface CityDao {
    /**
     * 根据城市名称，查询城市信息
     *
     * @param cityName 城市名
     */
    City findByName(@Param("cityName") String cityName);

    List<Mobile> findByStoreProc(@Param("cityName") String cityName);

    List<Mobile> findByStoreProc2(@Param("tempTableName") String tempTableName);

}
