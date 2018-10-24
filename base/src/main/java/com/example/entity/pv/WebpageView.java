package com.example.entity.pv;

import com.example.commons.Myjob;

import java.io.Serializable;
import java.util.Date;


public class WebpageView implements Serializable {

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

    public String getApp_name() {
        return app_name;
    }

    public void setApp_name(String app_name) {
        this.app_name = app_name;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public int getVisit_num() {
        return visit_num;
    }

    public void setVisit_num(int visit_num) {
        this.visit_num = visit_num;
    }

    public int getVisit_ip_num() {
        return visit_ip_num;
    }

    public void setVisit_ip_num(int visit_ip_num) {
        this.visit_ip_num = visit_ip_num;
    }

    public int getVisit_user_num() {
        return visit_user_num;
    }

    public void setVisit_user_num(int visit_user_num) {
        this.visit_user_num = visit_user_num;
    }

    public int getVisit_jump_percent() {
        return visit_jump_percent;
    }

    public void setVisit_jump_percent(int visit_jump_percent) {
        this.visit_jump_percent = visit_jump_percent;
    }

    public int getVisit_new_num() {
        return visit_new_num;
    }

    public void setVisit_new_num(int visit_new_num) {
        this.visit_new_num = visit_new_num;
    }

    public int getVisit_session_num() {
        return visit_session_num;
    }

    public void setVisit_session_num(int visit_session_num) {
        this.visit_session_num = visit_session_num;
    }

    public Date getImport_date() {
        return import_date;
    }

    public void setImport_date(Date import_date) {
        this.import_date = import_date;
    }

    private String app_id;

    private String app_name;

    private Date create_date;

    private int visit_num;

    private int visit_ip_num;
    private int visit_user_num;
    private int visit_jump_percent;
    private int visit_new_num;
    private int visit_session_num;

    private Date import_date;
}
