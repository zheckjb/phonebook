package com.tsi.jb;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Reminder extends Note {
    private String remDate;
    private LocalDate remDateDt;

    public String getRemDate() {
        return remDate;
    }

    public void setRemDate(String remDate) {
        this.remDate = remDate;
    }

    public LocalDate getRemDateDt() {
        return remDateDt;
    }

    public void setRemDateDt(String tmp) {
//        int year = Integer.parseInt(tmp.substring(0,4));
//        int month = Integer.parseInt(tmp.substring(4,6));
//        int day = Integer.parseInt(tmp.substring(6,8));
//        this.remDateDt = LocalDate.of(year,month,day);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        this.remDateDt = LocalDate.parse(tmp,formatter);
    }

    @Override
    public String toString() {
       if (remDate == null) {
            remDate = remDateDt.toString();
        }
        return String.format("Nr. %02d %s %s %s", getId(), getName(), remDate, getNote());
    }

    @Override
    public boolean contains(String str) {
        return super.contains(str);
    }


}
