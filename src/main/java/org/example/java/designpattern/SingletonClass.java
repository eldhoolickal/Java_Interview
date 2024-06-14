package org.example.java.designpattern;

public class SingletonClass {

    private static SingletonClass singletonClassInstance = null;

    private SingletonClass(){
    }

    public static SingletonClass getInstance(){
        if(singletonClassInstance == null){
            singletonClassInstance = new SingletonClass();
        }
      return singletonClassInstance;
    }

    public static void main(String[] args) {
        SingletonClass s1 = SingletonClass.getInstance();
        SingletonClass s2 = SingletonClass.getInstance();
        SingletonClass s3 = SingletonClass.getInstance();

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

        System.out.println(s1==s2);
    }
}
