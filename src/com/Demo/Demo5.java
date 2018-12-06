package com.Demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import java.util.*;
public class Demo5
{
    public static void main(String[] args)
    {
        int[] array = {6,9,8};
        List<Integer> list = new ArrayList<>();
        list.add(array[0]);
        list.add(array[2]);
        list.set(1, array[1]);
        list.remove(0);
        System.out.println(list);
        System.out.println(list);
    }
}
@FunctionalInterface
interface Added{int getInput(int a, int b);}

interface SmartAdded extends Added{int getInput(double a, double b);}

@FunctionalInterface
interface FuncInt {
    int getInput(int num1, int num2);
    default int getValue(){
        return 0;
    }

}