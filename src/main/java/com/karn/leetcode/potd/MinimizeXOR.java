package com.karn.leetcode.potd;

public class MinimizeXOR {
    public static void main(String[] args) {
        System.out.println(new MinimizeXOR().minimizeXor(12, 5));
    }
    public int minimizeXor(int num1, int num2) {
        int n1 = countSetBits(num1);
        int n2 = countSetBits(num2);
        while(n1<n2){
            //while n1 bits < n2 bits, set unset bits of n1 from right to left
            num1 = setRightMostBit(num1);
            n1++;
        }
        while(n1>n2){
            //while n1 bits > n2 bits, unset set bits of n1 from right to left
            num1 = unsetRightMostBit(num1);
            n1--;
        }
        return num1;
    }
    private int setRightMostBit(int num){
        int set = 1;
        int copy = num;
        while(copy>0){
            if((copy&1)==0){
                break;
            }
            set <<= 1;
            copy >>= 1;
        }
        num = num|set;
        return num;
    }
    private int unsetRightMostBit(int num){
        int set = 1;
        while((set&num)==0){
            set = set<<1;
        }
        num = num^set;
        return num;
    }
    private int countSetBits(int num){
        int count = 0;
        while(num>0){
            count += num & 1;
            num >>= 1;
        }
        return count;
    }
}
