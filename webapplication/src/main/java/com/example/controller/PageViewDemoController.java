package com.example.controller;


import com.alibaba.fastjson.JSON;
import com.example.Md5Utils;
import com.example.annotation.MyLog;
import com.example.entity.City;
import com.example.entity.Mobile;
import com.example.entity.YoushuEventView;
import com.example.entity.YoushuPageView;
import com.example.service.CityService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.spy.memcached.MemcachedClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.*;

/**
 *
 */
@RestController
public class PageViewDemoController {

    private static Logger logger = LoggerFactory.getLogger(PageViewDemoController.class);

    @Autowired
    private MemcachedClient memcachedClient;

    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/webPageApi", produces="application/json;charset=UTF-8",method = RequestMethod.GET)
    public String demoForWebpageViewApi(@RequestParam("appId") String appId,@RequestParam("date") String date) {

        YoushuPageView youshuPageView = new YoushuPageView();
        YoushuPageView.PageView pageView = youshuPageView.new PageView();
        pageView.setDate("2018-09-18");
        pageView.setVisit_ip_num(133);
        pageView.setVisit_jump_percent(108);
        pageView.setVisit_num(111);
        pageView.setVisit_num(1333);
        pageView.setVisit_page_num_avg(133);
        pageView.setVisit_session_num(11);
        pageView.setVisit_page_num_avg(11);
        pageView.setVisit_user_num(11111);

        youshuPageView.setData(pageView);
        youshuPageView.setResultCode(1);

        String str = JSON.toJSONString(youshuPageView);

        return str;
    }

    @RequestMapping(value = "/webPageApi2", produces="application/json;charset=UTF-8",method = RequestMethod.GET)
    public YoushuPageView demoForWebpageViewApi2(@RequestParam("appId") String appId,@RequestParam("date") String date) {

        YoushuPageView youshuPageView = new YoushuPageView();
        YoushuPageView.PageView pageView = youshuPageView.new PageView();
        pageView.setDate("2018-09-18");
        pageView.setVisit_ip_num(133);
        pageView.setVisit_jump_percent(108);
        pageView.setVisit_num(111);
        pageView.setVisit_num(1333);
        pageView.setVisit_page_num_avg(133);
        pageView.setVisit_session_num(11);
        pageView.setVisit_page_num_avg(11);
        pageView.setVisit_user_num(11111);

        youshuPageView.setData(pageView);
        youshuPageView.setResultCode(1);


        return youshuPageView;
    }

    @RequestMapping(value = "/eventPageApi", produces="application/json;charset=UTF-8",method = RequestMethod.GET)
    public String demoForEventViewApi(@RequestParam("appId") String appId,@RequestParam("date") String date) {

        YoushuEventView youshuEventView = new YoushuEventView();
        youshuEventView.setDate("20180919");
        youshuEventView.setResultCode(1);
        List<YoushuEventView.EventView> arr = new ArrayList<YoushuEventView.EventView>();
        for(int i=0;i<5;i++)
        {
            YoushuEventView.EventView eventView = youshuEventView.new EventView();
            eventView.setEvent("event "+i);
            eventView.setTouch_num(133+i);
            eventView.setTouch_user_num(134+i);
            arr.add(eventView);
        }
        youshuEventView.setData(arr);
        String str = JSON.toJSONString(youshuEventView);
        logger.info("---str="+str);
        //YoushuEventView myObj = JSON.parseObject(str,YoushuEventView.class);

        return str;
    }


}
