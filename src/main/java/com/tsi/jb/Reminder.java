package com.tsi.jb;

import java.time.LocalDate;


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

    public void setRemDateDt(LocalDate remDateDt) {
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
