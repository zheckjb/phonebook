package com.tsi.jb;

/**
 * Created by Zheck on 19.03.2017.
 */
public abstract class Record {
    // static - define variable unique for all classes of Record
    // class variables (define by 'static')
    private static int count = 0;
    // instance variables
    private int id;
    private String name;

    public Record() {
        count++;
        id = count;
        //or id = ++count;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // - possible, but if toString will be formatted with any keyword, it can fall to search
    public boolean contains2(String str) {
        if (this.toString().toLowerCase().contains(str)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean contains(String str) {
        return name.toLowerCase().contains(str);
    }

}
