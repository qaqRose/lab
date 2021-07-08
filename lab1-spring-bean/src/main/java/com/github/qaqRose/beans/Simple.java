package com.github.qaqRose.beans;

import java.util.Date;

/**
 * @author qiu
 * 2021/5/26
 */
public class Simple {
    private Integer a;
    private String b;
    private Date c;

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public Date getC() {
        return c;
    }

    public void setC(Date c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "Simple{" +
                "a=" + a +
                ", b='" + b + '\'' +
                ", c=" + c +
                '}';
    }
}
