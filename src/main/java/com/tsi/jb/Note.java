package com.tsi.jb;

/**
 * Created by JavaCourses on 29.03.2017..
 */
public class Note extends Record {
    private String Note;

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        this.Note = note;
    }

    @Override
    public String toString() {
        return String.format("Nr. %02d %s %s", getId(), getName(), Note);
    }


}
