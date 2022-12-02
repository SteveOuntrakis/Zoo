package com.company;

import java.io.Serializable;

public class Animal implements Serializable {
    private int id,max_age;
    private String name,classis;
    private double weight;

    public int getId() {
        return id;
    }

    public void setId(int id) {
            this.id = id;
    }

    public int getMax_age() {
        return max_age;
    }

    public void setMax_age(int max_age) {
        this.max_age = max_age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassis() {
        return classis;
    }

    public void setClassis(String classis) {
        this.classis = classis;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
