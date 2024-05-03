package com.karn.leetcode;

public class StringToInteger {
    public static void main(String[] args) {
        System.out.println(new StringToInteger().myAtoi("    -88827   5655  U"));
    }
    public int myAtoi(String s) {
        s=s.trim();
        boolean leadingZero = true;
        int number = 0;
        boolean anyDigit = false;
        boolean negative = false;
        boolean signed = false;
        for(int i=0;i<s.length();i++){
            if((number==Integer.MIN_VALUE)||(number == Integer.MAX_VALUE)){
                return number;
            }
            char c = s.charAt(i);
            if(c=='0'){
                anyDigit = true;
                if(leadingZero){
                    continue;//ignore
                }
                number = makeNumber(number, 0 ,negative);
            } else if(c>='1'&&c<='9'){
                anyDigit = true;
                leadingZero = false;
                number = makeNumber(number, (c-'0'),negative);
            } else if(c=='-'||c=='+'||c==' '){

                if((c=='-'||c=='+')&&anyDigit){
                    break;
                }
                if(c=='-'){
                    negative=true;
                }
                if((c=='-'||c=='+')&&!signed){
                    signed=true;
                }else if((c=='-'||c=='+')&&signed){
                    return 0;
                }else if(anyDigit){
                    break;
                }

            }else{
                break;
            }
        }

        return negative?-number:number;
    }

    private int makeNumber(long number,int newNumber,boolean negative){
        number = (number*10)+newNumber;
        if(negative){
            if(number>Integer.MAX_VALUE){
                return Integer.MIN_VALUE;
            }
        }else{
            if(number>Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
        }
        return (int) number;
    }
}
