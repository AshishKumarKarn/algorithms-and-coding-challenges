package com.karn.leetcode;

import java.util.Stack;

public class BackspaceStringCompare {
    public boolean backspaceCompare(String s, String t) {
        char[] sChars = s.toCharArray();
        for (char sChar : sChars) {
            if (sChar != '#')
                sStack.push(sChar);
            else
                sStack.pop();
        }
        char[] tChars = t.toCharArray();
        for (char tChar : tChars) {
            if (tChar != '#')
                tStack.push(tChar);
            else
                tStack.pop();
        }
        return sStack.equals(tStack);

    }

    private final Stack<Character> sStack = new Stack<>();
    private final Stack<Character> tStack = new Stack<>();

}
