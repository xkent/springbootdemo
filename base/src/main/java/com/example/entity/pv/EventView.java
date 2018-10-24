package com.example.entity.pv;

import java.io.Serializable;
import java.util.Date;


public class EventView implements Serializable {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public int getEvent() {
        return event;
    }

    public void setEvent(int event) {
        this.event = event;
    }

    public int getTouch_num() {
        return touch_num;
    }

    public void setTouch_num(int touch_num) {
        this.touch_num = touch_num;
    }

    public int getTouch_user_num() {
        return touch_user_num;
    }

    public void setTouch_user_num(int touch_user_num) {
        this.touch_user_num = touch_user_num;
    }

    public Date getImport_date() {
        return import_date;
    }

    public void setImport_date(Date import_date) {
        this.import_date = import_date;
    }

    private String app_id;


    private Date create_date;

    private int event;

    private int touch_num;
    private int touch_user_num;

    private Date import_date;
}
