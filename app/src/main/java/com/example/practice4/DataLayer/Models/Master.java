package com.example.practice4.DataLayer.Models;

public class Master {
    private String name;
    public Master(String name){
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
