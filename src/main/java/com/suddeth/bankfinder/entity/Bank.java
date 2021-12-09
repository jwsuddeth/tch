package com.suddeth.bankfinder.entity;

public class Bank {

    private int id;
    private String name;
    private String type;
    private String city;
    private String state;
    private String zip;

    public Bank(){
        this(0, "", "", "", "", "");
    }

    public Bank(int id, String name, String type, String city, String state, String zip){
        this.id = id;
        this.name = name;
        this.type = type;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getType() { return type; }
    public String getCity() { return city; }
    public String getState() { return state; }
    public String getZip() { return zip; }

    public Bank setId(int id) {
        this.id = id;
        return this;
    }

    public Bank setName(String name){
        this.name = name;
        return this;
    }

    public Bank setType(String type){
        this.type = type;
        return this;
    }

    public Bank setCity(String city){
        this.city = city;
        return this;
    }

    public Bank setState(String state){
        this.state = state;
        return this;
    }

    public Bank setZip(String zip){
        this.zip = zip;
        return this;
    }

    @Override
    public String toString(){
        return String.format("ID=%d, Name=%s, Type=%s, City=%s, State=%s, Zip=%s", id, name, type, city, state, zip);
    }
}
