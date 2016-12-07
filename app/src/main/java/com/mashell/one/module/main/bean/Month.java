package com.mashell.one.module.main.bean;

import java.io.Serializable;

/**
 * Created by mashell on 16/12/3.
 * Email: mashell624@163.com
 * Github: https://github.com/mashell
 */

public class Month implements Serializable {
    public String monthKey;
    public String monthValue;

    public Month(String monthValue, String monthKey) {
        this.monthValue = monthValue;
        this.monthKey = monthKey;
    }
}
