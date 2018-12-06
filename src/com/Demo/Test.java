package com.Demo;

import java.util.ArrayList;
import java.util.Collections;

@FunctionalInterface
interface LambdaTest {
     int getLength(String s);
}

public class Test {
    public static void main(String[] args) {
        LambdaTest lt = s -> {return s.length();};

        System.out.println(lt.getLength("Hello"));
        System.out.println(lt.getLength("With Lambda"));

        ArrayList<String> l = new ArrayList<String>();

        l.add("A");
        l.add("B");
        l.add("C");
//        l.add(10);
//        l.add(20);


        Collections.sort(l,(a,b) -> -a.compareTo(b));

        System.out.println(l);
    }
}