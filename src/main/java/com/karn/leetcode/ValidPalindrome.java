package com.karn.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        List<Character> characterList = new ArrayList<>(chars.length);
        for (char c: chars) {
            if(c>='a'&&c<='z'||c>='0'&&c<='9'){
                characterList.add(c);
            }
        }
        for (int i = 0,j=characterList.size()-1; i<=j; i++,j--) {
            if(characterList.get(i)!=characterList.get(j)){
                return false;
            }
        }
        return true;
    }
}
