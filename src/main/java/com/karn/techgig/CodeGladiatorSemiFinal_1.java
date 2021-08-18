package com.karn.techgig;

import java.util.Scanner;

public class CodeGladiatorSemiFinal_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int total = 0;
        for (int i = 0; i < count; i++) {
            int balls = sc.nextInt();
            total += countMoves(balls);
        }

    }

    private static int countMoves(int balls) {
        int moves = checkDivisibleBy(balls);
        if(moves==1){
            return moves+1;
        }else{
            balls=balls/moves;
//            countMoves(bsl)
        }
        return 0;
    }

    private static int checkDivisibleBy(int balls) {
        if(balls<=1){
            return 1;
        }
        if(balls%2==0){
            return 2;
        }
        if(balls%3==0){
            return 3;
        }
        if(balls%5==0){
            return 5;
        }
        for (int i = 7; i*i < balls; i++) {
            if(balls%i==0){
                return i;
            }
        }
        return 1;
    }
}
