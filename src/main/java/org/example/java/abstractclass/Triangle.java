package org.example.java.abstractclass;

public class Triangle extends Shape{

    private double base;

    private double hieght;

    public Triangle(double base, double hieght) {
        this.base = base;
        this.hieght = hieght;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * hieght;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Triangle with base:"+base+" height:"+hieght);
    }
}
