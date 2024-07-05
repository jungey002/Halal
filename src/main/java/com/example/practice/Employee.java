package com.example.practice;

public class Employee {

    private int eid;
    private double salary; // Changed to double for salary
    private String phone; // Changed to String for phone
    private String name;

    public Employee(int eid, String name, double salary, String phone) {
        this.eid = eid;
        this.name = name;
        this.salary = salary;
        this.phone = phone;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
