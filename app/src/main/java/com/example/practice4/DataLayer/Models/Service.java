package com.example.practice4.DataLayer.Models;

public class Service {
    private String name;

    public Service(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
    @Override
    public String toString(){
        return name;
    }
}
