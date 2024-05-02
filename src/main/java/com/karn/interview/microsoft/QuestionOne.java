package com.karn.interview.microsoft;

import com.karn.kickstart.ks2021.Solution;

public class QuestionOne {
    public static void main(String[] args) {
        System.out.println(new QuestionOne().solution("aaabab", 0));
    }
    public int solution(String L, int start) {
        // Implement your solution here
        if(L.length()%2!=0){
            return -1;
        }
        int result= solution(L.toCharArray(), start,0);
        if(result== Integer.MAX_VALUE){
            return -1;
        } else {
            return result;
        }
    }
    

    private int solution(char[] arr, int start,int count){
        if(getCountOfaNb(arr).areEqual()){
            return count;
        }
        int leftCount=0;
        int leftRes= Integer.MAX_VALUE;
        char[] LEFT=new char[arr.length];
        for(int j=0;j<arr.length;j++){
            LEFT[j]=arr[j];
        }
        for(int i=start-1;i>=0;i--){
            leftCount++;
            flip(LEFT, i);
            if(getCountOfaNb(LEFT).areEqual()){
                leftRes=leftCount;
                break;
            }
        }
        int rightCount=0;
        int rightRes=Integer.MAX_VALUE;
        char[] RIGHT=new char[arr.length];
        for(int j=0;j<arr.length;j++){
            RIGHT[j]=arr[j];
        }
        for(int i=start;i<arr.length;i++){
            rightCount++;
            flip(RIGHT, i);

            if(getCountOfaNb(RIGHT).areEqual()) {
                rightRes = rightCount;
                break;
            }
        }
        return Math.min(leftRes,rightRes);
    }
    private void flip(char[] arr,int index){
        if(arr[index]=='a'){
            arr[index]='b';
        }else{
            arr[index]='a';
        }
    }

    private Count getCountOfaNb(char[] arr){
        int countA=0;
        int countB=0;
        for(char i:arr){
            if(i=='a'){
                countA++;
            }else if(i=='b'){
                countB++;
            }
        }
        return new Count(countA,countB);
    }

    class Count{
        int countA;
        int countB;
        Count(int countA,int countB){
            this.countA=countA;
            this.countB=countB;
        }
        public boolean areEqual(){
            return this.countA==this.countB;
        }
    }
}
