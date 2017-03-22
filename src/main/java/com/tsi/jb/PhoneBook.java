package com.tsi.jb;

import asg.cliche.Command;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zheck on 19.03.2017.
 */
public class PhoneBook {
    //recordList - variable to store array of Record
    private List<Record> recordsList = new ArrayList<>();

    @Command(name = "create", abbrev = "c", description = "Add 1")
    public void create(String phName) {
        Record r = new Record();
        r.setName(phName);
        recordsList.add(r);
    }

    @Command(name = "create", abbrev = "c", description = "Add 2")
    public void create(String phName, String... phNumber) {
        Record r = new Record();
        r.setName(phName);
        r.setPhone(phNumber);
        recordsList.add(r);
    }

    @Command(name = "create", abbrev = "c2", description = "Add 2")
    public void create(String phName, String Email, String... phNumbers) {
        Record r = new Record();
        r.setName(phName);
        r.setEmail(Email);
        r.addPhones(phNumbers);
        recordsList.add(r);
    }

    @Command(name = "create", abbrev = "c3", description = "Add 3")
    public void create(String phName, String phNumber, String phEmail) {
        Record r = new Record();
        r.setName(phName);
        r.setPhone(phNumber);
        r.setEmail(phEmail);
        recordsList.add(r);
    }

    @Command(name = "addphones", abbrev = "aph")
    public void addPhones(int id, String phNumber) {
        for (Record r : recordsList) {
            if (r.getId() == id) {
                r.addPhones(phNumber);
                break;
            }
        }
    }

    @Command(name = "list", abbrev = "l", header = "List: ")
    public List<Record> list() {
        return recordsList;
    }

    @Command(name = "list", abbrev = "ls")
    public String listS() {
        return recordsList.toString();
    }

}
