package com.tsi.jb;

import asg.cliche.Command;
import asg.cliche.Shell;
import asg.cliche.ShellFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class PhoneBook {
    //recordList - variable to store array of Record
    //private List<Record> recordsList = new ArrayList<>();
    private Map<Integer, Record> recordsList = new HashMap<>();
    private NavigableMap<String, Record> IndexByName = new TreeMap<>();

    private Shell theShell;

    public void cliSetShell(Shell theShell) {
        this.theShell = theShell;
    }

    @Command(name = "create", abbrev = "c1", description = "Add only name")
    public void create(String phName) {
        Person r = new Person();
        r.setName(phName);
        //recordsList.add(r);
        recordsList.put(r.getId(), r);
    }

    @Command(name = "create", abbrev = "c2", description = "Add name and  phones")
    public void create(String phName, String... phNumber) {
        Person r = new Person();
        r.setName(phName);
        r.setPhone(phNumber);
        //recordsList.add(r);
        recordsList.put(r.getId(), r);
    }

    @Command(name = "create", abbrev = "c4", description = "Add 4")
    public void create(String phName, String phNumber, String phEmail) {
        Person r = new Person();
        r.setName(phName);
        r.setPhone(phNumber);
        r.setEmail(phEmail);
        recordsList.put(r.getId(), r);
        //recordsList.add(r);
    }

    @Command(name = "create", abbrev = "cp", description = "Add name, email, phones")
    public void create(String phName, String Email, String... phNumbers) {
        Person r = new Person();
        r.setName(phName);
        r.setEmail(Email);
        r.addPhones(phNumbers);
        //recordsList.add(r);
        recordsList.put(r.getId(), r);
        IndexByName.put(r.getName(), r);
    }

    @Command(name = "create", abbrev = "cn", description = "Add notes")
    public void createNote(String nName, String nNote) {
        Note r = new Note();
        r.setName(nName);
        r.setNote(nNote);
        //recordsList.add(r);
        recordsList.put(r.getId(), r);
    }

    @Command(name = "create", abbrev = "cnr", description = "Add notes")
    public void createNoteWithReminder(String nName, String nNote, String nDateTime) {
        Reminder r = new Reminder();
        r.setName(nName);
        r.setNote(nNote);
        r.setRemDate(nDateTime);
        //recordsList.add(r);
        recordsList.put(r.getId(), r);
    }

    @Command(name = "addphones", abbrev = "aph")
    public void addPhones(int id, String phNumber) {
        for (Record r : recordsList.values()) {
            if (r instanceof Person && r.getId() == id) {
                Person p = (Person) r;
                p.addPhones(phNumber);
                break;
            }
        }
    }
    @Command(name = "addnotes", abbrev = "apn")
    public void addNotes(int id, String myNote) {
        for (Record r : recordsList.values()) {
            if (r instanceof Note && r.getId() == id) {
                //Person p = (Person) r;
                //p.addPhones(phNumber);
                break;
            }
        }
    }

    @Command
    public Collection<Record> findAffter(String str) {
        return <>
    }

    @Command
    public Record show(int id) {
        return recordsList.get(id);
    }


    @Command(name = "edit", abbrev = "e")
    public void edit(int id) throws IOException {
        /*for (Record r : recordsList) {
            if (r instanceof Person && r.getId() == id) {
                Person p = (Person) r;
                ShellFactory.createSubshell("#" + id, theShell, "Edit record", p)
                        .commandLoop();
                break;
            }
        }*/
        Record r = recordsList.get(id);
        ShellFactory.createSubshell("#" + id, theShell, "Edit record", r)
                .commandLoop();

    }
    @Command(name = "find", abbrev = "f")
    public List<Record> find(String str) {
        List<Record> result = new ArrayList<>();
        for (Record r : recordsList.values()) {
            if (r instanceof Person) {
                String name = r.toString().toLowerCase();
                if (name.contains(str.toLowerCase())) {
                    result.add(r);
                }
            } else if (r instanceof Note) {
                String name = r.toString().toLowerCase();
                if (name.contains(str.toLowerCase())) {
                    result.add(r);
                }

            }
        }
        return result;
    }

    @Command(name = "find2", abbrev = "f2")
    public List<Record> find2(String str) {
        str = str.toLowerCase();
        List<Record> result = new ArrayList<>();
        for (Record r : recordsList.values()) {
            String name = r.getName().toLowerCase();
            //if statement in asigment of variable
            String email = r instanceof Person ? ((Person) r).getEmail().toLowerCase() : "";
            if (name.contains(str) || email.contains(str)) {
                result.add(r);

            }
        }
        return result;
    }

    @Command(name = "find3", abbrev = "f3")
    public List<Record> find3(String str) {
        str = str.toLowerCase();
        List<Record> result = new ArrayList<>();
        for (Record r : recordsList.values()) {
            if (r.contains2(str)) {
                result.add(r);
            }
        }
        return result;
    }


    @Command(name = "find4", abbrev = "f4")
    public List<Record> find4(String str) {
        str = str.toLowerCase();
        List<Record> result = new ArrayList<>();
        for (Record r : recordsList.values()) {
            if (r.contains(str)) {
                result.add(r);
            }
        }
        return result;
    }

    /*
        @Command(name = "list", abbrev = "l", header = "List: ")
        public List<Record> list() {
            return recordsList;
        }

        @Command(name = "list", abbrev = "ls")
        public String listS() {
            return recordsList.toString();
        }
        */
    @Command
    public Collection<Record> list() {
        return recordsList.values();
    }

    @Command(name = "save", abbrev = "sv")
    public void saveRecord() {
        try {
            File myFile = new File("db.txt");
            FileWriter fileStr = new FileWriter(myFile);
            for (Record r : recordsList.values()) {
                fileStr.write(String.format("%s \r\n", r));
            }
            fileStr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
