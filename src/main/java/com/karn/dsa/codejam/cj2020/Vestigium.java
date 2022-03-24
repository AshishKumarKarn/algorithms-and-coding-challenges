package com.karn.dsa.codejam.cj2020;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//https://codingcompetitions.withgoogle.com/codejam/round/000000000019fd27/000000000020993c
//Vestigium 7pts
public class Vestigium {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int N = sc.nextInt();
            int[][] matrix = new int[N][N];
            int trace = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    matrix[j][k] = sc.nextInt();
                    if (j == k) {
                        trace += matrix[j][k];
                    }

                }
            }
            int r = 0;
            int c = 0;



            for (int j = 0; j < N; j++) {
                Set<Integer> rows=new HashSet<>();
                Set<Integer> columns=new HashSet<>();
                boolean notFoundR = true;
                boolean notFoundC = true;

                for (int k = 0; k < N; k++) {
                    if(!notFoundC&&!notFoundR){
                        break;
                    }
                    if(notFoundR&&rows.contains(matrix[j][k])){
                        r++;
                        notFoundR=false;
                    }else{
                        rows.add(matrix[j][k]);
                    }
                    if(notFoundC&&columns.contains(matrix[k][j])){
                        c++;
                        notFoundC=false;
                    }else{
                        columns.add(matrix[k][j]);
                    }

                }
            }
            System.out.println("Case #" + i + ": " + trace + " " + r + " " + c);
        }
    }
}
