package com.example.dao;


import com.example.entity.pv.EventView;
import com.example.entity.pv.WebpageView;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface WebpageViewDao {

    void insertWebpageView(WebpageView webpageView);

    @Select("SELECT COUNT(1) FROM `t_youshu_event_view` WHERE DATE_FORMAT(create_date,'%Y-%m-%D')=DATE_FORMAT(CURDATE()-0,'%Y-%m-%D') ")
    int queryHasRecordData();

    @Select("SELECT * FROM t_youshu_webpage_view")
    @Results({
            @Result(property = "app_id",  column = "app_id"),
            @Result(property = "import_date", column = "import_date"),
            @Result(property = "visit_ip_num", column = "visit_ip_num"),
            @Result(property = "create_date", column = "create_date")
    })
    List<WebpageView> queryListAll();

    @Insert("INSERT INTO t_youshu_event_view(app_id,create_date,event,touch_num,touch_user_num,import_date)" +
            " VALUES(#{app_id}, now(), #{event}, #{touch_num},#{touch_user_num},now())")
    void insertEventView(EventView eventView);
}
