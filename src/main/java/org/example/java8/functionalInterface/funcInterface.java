package org.example.java8.functionalInterface;

public class funcInterface {

    @FunctionalInterface
    public interface ArithmeticOperation{
        int operation(int op1,int op2);

    }


    public static void main(String[] args) {
        ArithmeticOperation addOperation = Integer::sum;
        System.out.println(addOperation.operation(1,2));

        ArithmeticOperation subOperation = (op1, op2) -> { return op1 - op2; };
        System.out.println(subOperation.operation(4,2));
    }
}
