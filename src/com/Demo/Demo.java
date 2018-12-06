package com.Demo;


interface Interf {
    default public void m1() {
        System.out.println("Default method called");
    }
}

interface Left {
    public static void m1() {
        System.out.println("Left default method");
    }
}

interface Right {
    default void m1() {
        System.out.println("Right default method");
    }
}

public class Demo implements Interf, Left, Right {

    static class Nested {
        public static void main(String[] args) {
            System.out.println("Nested class main method");
        }
    }

    public void m1() {
        System.out.println("Overridden Default method got called");
        Left.m1();
    }

    public static void main(String[] args) {
        System.out.println("Outer class main method");

        Demo d = new Demo();
        d.m1();

        Left.m1();
    }
}
