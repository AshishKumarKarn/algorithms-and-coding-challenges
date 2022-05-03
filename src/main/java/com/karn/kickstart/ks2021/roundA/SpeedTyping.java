package com.karn.kickstart.ks2021.roundA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class SpeedTyping {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String count =null;
            int res=0;
            String letter = sc.next();
            String typed = sc.next();
            Stack<Character> typedStack = new Stack<>();
            for (int j = 0; j < typed.length(); j++) {
                typedStack.push(typed.charAt(j));
            }
            int j=letter.length()-1;
            for (; j >= 0;) {
                if(!typedStack.isEmpty()){
                    Character pop = typedStack.pop();
                    if(letter.charAt(j)==pop){
                        j--;
                    }else{
                        res++;
                    }
                }else {
                    count="IMPOSSIBLE";
                    break;
                }
            }
            if(!typedStack.isEmpty()){
                res+=typedStack.size();
            }
            if(count==null){
                count = String.valueOf(res);
            }
            System.out.println("Case #" + i + ": " + count);
        }
    }
}
