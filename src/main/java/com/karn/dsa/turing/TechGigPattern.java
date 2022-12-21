package com.karn.dsa.turing;


//first question candies --
public class TechGigPattern {
    public static void main(String[] args) {
        int input=6;
        //for (int i = 0; i < 11; i++) {
          //  System.out.println("******FOR "+i+"******");
            printPattern(8);
            //System.out.println("****************");
     //   }
      //  printPattern(input);
    }

    private static void printPattern(int input) {
        boolean flag=true;
        int eventStart=200;
        int evenCounter = 2;
        int backupEven=200;
        int oddCounter=3;
        int lastOddValue=200;
        int backBackup=200;
        for (int i = 0; i < input; i++) {
            if(flag){
                backBackup = backupEven;
                backupEven=eventStart;
                System.out.println(eventStart);
                eventStart = (eventStart*evenCounter)+100;
                evenCounter++;
            }else{
                int startOdd = backBackup + lastOddValue;
                StringBuilder sb=new StringBuilder();
                sb.append(startOdd).append(" ");
                for (int j = 0; j < oddCounter-1 ; j++) {
                    startOdd += backupEven;
                    lastOddValue = startOdd;
                    sb.append(startOdd);
                    if(j<oddCounter-2){
                        sb.append(" ");
                    }
                }
                System.out.println(sb.toString());
                oddCounter++;
            }
            flag=!flag;
        }
    }
}
