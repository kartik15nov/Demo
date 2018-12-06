package com.Demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.nio.Buffer;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class WordCount {

    public static void main(String[] args) throws Exception {

        FileReader f = new FileReader("C:\\Users\\Kartik\\Desktop\\File.txt");
        HashMap<String, Integer> map = new HashMap<>();

        BufferedReader br = new BufferedReader(f);
        // The BufferedReader reads the lines
        while (br.read() != -1) {
            String line = br.readLine();
            String[] split = line.split(" ");

            /*for (String st : split) {
                if (map.containsKey(st))
                    map.put(st, map.get(st) + 1);
                else
                    map.put(st, 1);
            }*/


        }
        map.entrySet().stream()
                .sorted((k1, k2) -> -k1.getValue().compareTo(k2.getValue())).limit(10)
                .forEach(k -> System.out.println(k.getKey() + " : " + k.getValue()));
    }
}


