package com.karn.junk;

import java.util.Scanner;

public class AddTwoMatrix {
    public static void main(String[] args){
        try(Scanner sc=new Scanner(System.in);) {
            int m1 = sc.nextInt();
            int n1=sc.nextInt();
            int[][] matrix=new int[m1][n1];
            for (int i = 0; i < m1; i++) {
                for (int j = 0; j < n1; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            int m2 = sc.nextInt();
            int n2=sc.nextInt();
            if(m1!=m2||n1!=n2){
                throw new IllegalArgumentException("Can't add different matrix lengths");
            }
            for (int i = 0; i < m2; i++) {
                for (int j = 0; j < n2; j++) {
                    matrix[i][j] += sc.nextInt();
                }
            }
            System.out.println("Result Matrix : ");
            printMatrix(matrix);
        }
    }
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.printf("%d ", element);
            }
            System.out.println();
        }
        System.out.println();
    }
}
