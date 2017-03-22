package com.tsi.jb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Zheck on 19.03.2017.
 */
public class Record {
    //static - define variable unique for all classes of Record
    private static int count = 0;
    private int id;
    private String name;
    private String phone;
    private final List<String> phones = new ArrayList<>();
    private String email;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {

        this.phone = phone;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void addPhones(String... phones) {
        this.phones.addAll(Arrays.asList(phones));
    }

    public void setPhone(String[] phone) {

        this.phone = String.join(",", phone);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("Nr.%d %s %s %s", id, name, email, String.join(",", phones));
        //return id+". "+ this.name + " " + this.email + " " + this.phones;
    }
}
