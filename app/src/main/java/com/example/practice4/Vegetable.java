package com.example.practice4;

public class Vegetable {
    private String name;

    public Vegetable(String name){
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
