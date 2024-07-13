package org.example.java.designpattern.abstractclass;

public class ShapeMain {

    public static void main(String[] args) {
        Shape s1 = new Circle(5);
        s1.display();

        Shape s2 = new Triangle(3,4);
        s2.display();
    }
}
