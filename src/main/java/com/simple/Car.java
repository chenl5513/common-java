package com.simple;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/7/4.
 */
public class Car implements Serializable {


    private static final long serialVersionUID = -4509438322342833660L;


    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car(String name) {
        this.name = name;
    }

    public Car() {
    }
}
