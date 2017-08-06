package com.example;

public class Employee {
    int id;
    String name;
    String phone;



    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Employee( String name,int id) {

        this.name = name;
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Employee() {

    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

