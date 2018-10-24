package com.example.entity;

import java.io.Serializable;
import java.util.List;

public class YoushuEventView implements Serializable {

    private int resultCode;
    private List<EventView> data;

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public List<EventView> getData() {
        return data;
    }

    public void setData(List<EventView> data) {
        this.data = data;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    private String date;


    public class EventView {

        private String event;
        private int touch_num;
        private int touch_user_num;

        public String getEvent() {
            return event;
        }

        public void setEvent(String event) {
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
    }
}
