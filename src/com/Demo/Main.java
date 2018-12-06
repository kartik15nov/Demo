package com.Demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.Integer;

class Main {


    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int L[] = new int[N];
        int R[] = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer tk = new StringTokenizer(br.readLine());
            L[i] = Integer.parseInt(tk.nextToken());
            R[i] = Integer.parseInt(tk.nextToken());
        }
        align_rectangles(N, L, R);

    }

    public static void align_rectangles(int N, int L[], int R[]) {
        //Not that you need to update the arrays L and R as per the new aligned order

        Integer[] res = new Integer[N];
        for (int i = 0; i < N; i++) {

            res[i] = L[i] * R[i];

        }

        Arrays.sort(res, Collections.reverseOrder());


        for (int i = 0; i < res.length; i++) {

            for (int j = 0; j < res.length; j++) {

                if (res[i] == L[j] * R[j])
                    System.out.println(L[j] + " " + R[j]);

            }

        }


    }
}