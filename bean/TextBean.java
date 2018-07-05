package com.example.dell.quarterhour.bean;

/**
 * Created by DELL on 2018/6/11.
 */

public class TextBean {
    private String msg;
    private String code;

    @Override
    public String toString() {
        return "Test{" +
                "msg='" + msg + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public TextBean(String msg, String code) {

        this.msg = msg;
        this.code = code;
    }
}
