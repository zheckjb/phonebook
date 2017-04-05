package com.tsi.jb;

import java.util.Date;

/**
 * Created by Zheck on 04.04.2017.
 */
public class Reminder extends Note {
    private String remDate;
    private Date remDateDt;

    public String getRemDate() {
        return remDate;
    }

    public void setRemDate(String remDate) {
        this.remDate = remDate;
    }

    public Date getRemDateDt() {
        return remDateDt;
    }

    public void setRemDateDt(Date remDateDt) {
        this.remDateDt = remDateDt;
    }

    @Override
    public String toString() {
        return String.format("Nr. %02d %s %s %s", getId(), getName(), remDate, getNote());
    }

    @Override
    public boolean contains(String str) {
        return super.contains(str);
    }


}
