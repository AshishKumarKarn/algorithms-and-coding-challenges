package com.karn.techgig.potd;

import java.io.FileInputStream;
import java.util.Scanner;

public class MaximumIdenicalBowls {
    public static void main(String[] args) throws Exception{
        try(Scanner sc=new Scanner(new FileInputStream("maximumidenticalbowls.txt"))){
            int N = sc.nextInt();
            int[] arr=new int[N];
            for (int i = 0; i < N; i++) {
                arr[i]=sc.nextInt();
            }
            System.out.println(getMaximum(N, arr));
        }
    }
    public static int getMaximum(int N, int[] arr) {
        // code here
        long totalSum = 0;
        for(int i=0;i<N;i++){
            totalSum += arr[i];
        }
         System.out.println("totalSum::"+totalSum);
        int div=N;
        // System.out.println(totalSum%div);
        while(div>1){
            // System.out.println("div is" +div+" out"+(totalSum%div==0));
            if(totalSum%div!=0){
                div--;
                continue;
            }else{
                // int count = findCountOfSubSet((totalSum/div),N,arr);
                // System.out.println("Target is ::"+(totalSum/div)+" & Count is ::"+count);
                // if(count==div){
                return div;
                // }
            }
            //div--;
        }
        return 1;
    }

}
