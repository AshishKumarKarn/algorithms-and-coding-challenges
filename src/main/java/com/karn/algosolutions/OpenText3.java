package com.karn.algosolutions;

public class OpenText3 {
    public static void main(String[] args) {
        int N=9;
        System.out.println(new OpenText3().solution(N));
    }
        public int solution(int N) {
            if(N/10==0){
                return N;
            }
            int number =N;
            int result=0;
            int i=1;
            while(number/10>0){
                result = result + 9*i;
                i=i*10;
                number = number-9;
            }
            result=result+number*i;
            return result;
        }

}
