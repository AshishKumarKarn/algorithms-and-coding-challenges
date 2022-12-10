package com.karn.dsa.turing;

import java.util.ArrayList;
import java.util.List;

public class MorseCode {

    public List<String> solution(String morsecode){
        List<String> ans=new ArrayList<>();
        int counter=0;
        for (int i = 0; i < morsecode.length(); i++) {
            if(morsecode.charAt(i)=='.'){
                counter++;
            }else{
                counter=0;
                continue;
            }
            if(counter==2){
                counter=1;
                ans.add(morsecode.substring(0,i-1)+"--"+morsecode.substring(i+1));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new MorseCode().solution(".--.."));
    }
}
