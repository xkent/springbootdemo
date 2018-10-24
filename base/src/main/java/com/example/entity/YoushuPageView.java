package com.example.entity;

import java.io.Serializable;

public class YoushuPageView implements Serializable {
    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    private int resultCode;
    private PageView data;

    public PageView getData(){
        return this.data;
    }

    public void setData(PageView data) {
        this.data = data;
    }

    public class PageView{


        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public int getVisit_ip_num() {
            return visit_ip_num;
        }

        public void setVisit_ip_num(int visit_ip_num) {
            this.visit_ip_num = visit_ip_num;
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

        public int getVisit_num() {
            return visit_num;
        }

        public void setVisit_num(int visit_num) {
            this.visit_num = visit_num;
        }

        public int getVisit_page_num_avg() {
            return visit_page_num_avg;
        }

        public void setVisit_page_num_avg(int visit_page_num_avg) {
            this.visit_page_num_avg = visit_page_num_avg;
        }

        public int getVisit_session_num() {
            return visit_session_num;
        }

        public void setVisit_session_num(int visit_session_num) {
            this.visit_session_num = visit_session_num;
        }

        public String getVisit_stay_time_avg() {
            return visit_stay_time_avg;
        }

        public void setVisit_stay_time_avg(String visit_stay_time_avg) {
            this.visit_stay_time_avg = visit_stay_time_avg;
        }

        public int getVisit_user_num() {
            return visit_user_num;
        }

        public void setVisit_user_num(int visit_user_num) {
            this.visit_user_num = visit_user_num;
        }

        private String date;
        private int visit_ip_num;
        private int visit_jump_percent;
        private int visit_new_num;
        private int visit_num;
        private int visit_page_num_avg;
        private int visit_session_num;
        private String visit_stay_time_avg;
        private int visit_user_num;

    }
}
