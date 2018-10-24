package com.example.controller;


import com.alibaba.fastjson.JSON;
import com.example.Md5Utils;
import com.example.annotation.MyLog;
import com.example.entity.City;
import com.example.entity.Mobile;
import com.example.entity.YoushuEventView;
import com.example.entity.YoushuPageView;
import com.example.service.CityService;
import io.swagger.annotations.ApiImplicitParam;
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
public class MyRestController {

    private static Logger logger = LoggerFactory.getLogger(MyRestController.class);

    @Autowired
    private MemcachedClient memcachedClient;

    @Autowired
    private CityService cityService;

    @ApiOperation(value = "获取用户详细信息1", notes = "根据url的id来获取用户详细信息")
    @ApiParam(name = "aaaa", example = "gz")
    @MyLog(value = "这是我的值")
    @RequestMapping(value = "/jsonPost", produces="application/json;charset=UTF-8",method = RequestMethod.POST)
    public String myJson(@RequestBody String channelId) {

        Mobile aaaa = new Mobile();
        aaaa.setMobileNumber("13725359710");
        aaaa.setIsBlacklisted(1);

        String str = JSON.toJSONString(aaaa);
        Mobile parseMobile = JSON.parseObject(str,Mobile.class);


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

        str = JSON.toJSONString(youshuPageView);

        logger.info("---str="+str);

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
        str = JSON.toJSONString(youshuEventView);
        logger.info("---str="+str);
        YoushuEventView myObj = JSON.parseObject(str,YoushuEventView.class);

        logger.info("---parseMobile mobile="+myObj);
        logger.info("---->channelId="+channelId);

        return channelId;
    }


    @ApiOperation(value = "获取用户详细信息1", notes = "根据url的id来获取用户详细信息")
    @ApiParam(name = "aaaa", example = "gz")
    @MyLog(value = "这是我的值")
    @RequestMapping(value = "/a/{cityName}", method = RequestMethod.GET)
    public City myPath(@PathVariable String cityName) {
        logger.info("---->");
        City city = cityService.findCityByName(cityName);
        memcachedClient.set("tonyKey", 1000, "myVal1");
        String aaaa = (String) memcachedClient.get("tonyKey");

        return city;
    }

    @ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
    @ApiIgnore
    @RequestMapping(value = "/a2/{cityName}", method = RequestMethod.POST)
    public City myPath2(@PathVariable String cityName) {
        logger.info("---->");
        City city = cityService.findCityByName(cityName);

        return city;
    }

    /**
     * 参数名做自然排序
     *
     * @param map
     * @return
     */
    private String mapToString(Map<String, String> map) {
        if (null == map || map.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append(entry.getValue());
        }
        return sb.toString();
    }

    @ApiOperation(value = "排序所有参数", notes = "根据url的id来获取用户详细信息")
    @ApiIgnore
    @RequestMapping(value = "/resort", method = RequestMethod.GET)
    public String resortMap(@RequestParam("appId") String appId, @RequestParam("appKey") String appKey,
                            @RequestParam("msgId") String msgId, @RequestParam("myDate") String myDate,
                            @RequestParam("phone") String phone,@RequestParam("returnUrl") String returnUrl) {
        logger.info("---->resortMap appId=" + appId + "appKey=" + appKey + "msgId=" + msgId + "myDate=" + myDate);

        StringBuffer sb = new StringBuffer();
        Map<String, String> treeMap1 = new HashMap<String, String>();
        treeMap1.put("appId", appId);
        treeMap1.put("msgId", msgId);
        treeMap1.put("appKey", appKey);
        treeMap1.put("phone", phone);
        treeMap1.put("returnUrl", returnUrl);


        //if (null != myDate && !myDate.isEmpty()) {
        //    Date current = new Date();
        //    myDate = new String("" + current.getTime());
        //}
        //treeMap1.put("myDate", myDate);
        Set<String> arr = treeMap1.keySet();
        Iterator<String> it = arr.iterator();
        while (it.hasNext()) {
            String str = it.next();
            sb.append(treeMap1.get(str));
        }

        String aaa = Md5Utils.toMD5(mapToString(treeMap1));
        System.out.println("aaa1 MD5="+aaa);
        aaa = Md5Utils.toMD5(mapToString(treeMap1));
        System.out.println("aaa2 MD5="+aaa);
        //Md5Utils.encrypByMd5Jar(sb.toString());
        return aaa;
    }

}
