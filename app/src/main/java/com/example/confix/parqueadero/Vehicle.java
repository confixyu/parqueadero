package com.example.confix.parqueadero;

public class Vehicle {
    private int id;
    private String license;
    private String time_in;
    private String time_out;
    private int cost;

    public Vehicle() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getTime_in() {
        return time_in;
    }

    public void setTime_in(String time_in) {
        this.time_in = time_in;
    }

    public String getTime_out() {
        return time_out;
    }

    public void setTime_out(String time_out) {
        this.time_out = time_out;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    /*@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(friendName).append(System.getProperty("line.separator"));
        sb.append(houseNumber).append(System.getProperty("line.separator"));
        sb.append(road));

        return "id: " + id + "\n" +
                "license: " + license + "\n" +
                "time_in: " + time_in + "\n" +
                "time_out: " + time_out + "\n" +
                "cost: " + cost;
    }*/
}
