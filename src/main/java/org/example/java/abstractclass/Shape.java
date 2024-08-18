package org.example.java.abstractclass;

public  abstract class Shape {

    public abstract double calculateArea();

    public abstract void draw();

    public void display(){
        System.out.println("Drawing a " + getClass().getSimpleName());
        draw();
        System.out.println("Area: " + calculateArea());
    }
}
