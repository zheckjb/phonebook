package com.tsi.jb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Person extends Record {
    private String phone;
    private final List<String> phones = new ArrayList<>();
    private String email;


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
        return String.format("Nr. %02d %s %s %s", getId(), getName(), email, String.join(",", phones));
        //bad string
        //return id+". "+ this.name + " " + this.email + " " + this.phones;
    }

    @Override
    public boolean contains(String str) {
        boolean result = email.toLowerCase().contains(str) || super.contains(str);
        if (!result)  {
            for (String ph : phones) {
                result =  ph.toLowerCase().contains(str);
            }
        }
        return result;
    }
}
