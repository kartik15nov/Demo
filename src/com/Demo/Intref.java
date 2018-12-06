package com.Demo;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

class Test1 {
    public static void main(String[] args) {

        Predicate<String> p = S -> S.charAt(0) == 'K' || S.charAt(0) == 'k';

        Predicate<String> p1 = S -> S != null && S.trim().length() != 0 ;

//        System.out.println(p.and(p.negate()).test("Hello"));
        System.out.println(p.test("Hello World, How are you"));
        System.out.println(p.test("Kartik, How are you"));

        String[] names = {"Durga", null, "", "Ravi", "     ", "Shiva      ", null};

        ArrayList<String> l = new ArrayList<String>();

        for (String s : names) {

            if (p1.test(s))
                l.add(s);
        }

        System.out.println(names);
        System.out.println(l);

//        Functrion

        Function<String,Integer> f= s->s.length();

        System.out.println(f.apply("Durga"));
        System.out.print(f.apply("Hello world"));

        Function<String,String> f1=s->s.replaceAll(" ","");

        System.out.println(f1.apply("Hello                        world"));

//        To calculate the number of spaces present in the string
//        Total length with spaces - lenght without soaces
        Function<String, Integer> f2 = s -> s.length()- s.replaceAll(" ","").length();
        System.out.println(f2.apply("Hellow World how are you"));

//Consumer Chaining example

        Consumer<Integer> c1= i->System.out.println((i+i));
        Consumer<Integer> c2= i->System.out.println((i*i));
        Consumer<Integer> c3= i->System.out.println((i*i*i));

        System.out.println("Consumer result is : ");
        c1.andThen(c2).andThen(c3).accept(2);
    }
}