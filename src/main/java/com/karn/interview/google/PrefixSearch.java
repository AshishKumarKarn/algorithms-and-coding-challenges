package com.karn.interview.google;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PrefixSearch {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.addWord("apple");
        trie.addWord("application");
        trie.addWord("appendix");
        trie.addWord("iphone");
        trie.addWord("samsung");
        trie.addWord("iocas");
        trie.addWord("ashish");

        List<String> app = trie.getWords("app");
        System.out.println(app);

    }
}

class Trie {

    Trie[] children = new Trie[26];
    boolean isEnding;

    void addWord(String word) {
        Trie trie = this;
        char[] letters = word.toCharArray();
        for (char ch : letters) {
            if (trie.children[ch - 'a'] == null) {
                trie.children[ch - 'a'] = new Trie();
            }
            trie = trie.children[ch - 'a'];
        }
        trie.isEnding = true;
    }

    List<String> getWords(String prefix) {
        char[] letters = prefix.toCharArray();
        Trie trie = this;
        List<String> result = new ArrayList<>();
        for(char ch: letters){
            if(trie.children[ch-'a']==null){
                //word not found return empty
                return result;
            }
            trie = trie.children[ch-'a'];
        }
        Trie[] children = trie.children;

        for (int i = 0; i < children.length; i++) {
            if(children[i]!=null){
                List<String> words = new ArrayList<>();
                Stack<Character> characters = new Stack<>();
                characters.add((char)('a'+i));
                dfs(children[i].children, words, characters);
                result.addAll(words);
            }
        }
        return result.stream().map(str -> prefix + str).toList();
    }

    private void dfs(Trie[] children, List<String> words, Stack<Character> stack) {
        for(int i=0;i<children.length;i++){
            if(children[i]!=null&&children[i].isEnding){
                stack.push((char)('a'+i));
                StringBuilder sb =new StringBuilder();
                for(char c:stack){
                    sb.append(c);
                }
                words.add(sb.toString());
                stack.pop();
            }else if(children[i]!=null){
                stack.push((char)('a'+i));
                dfs(children[i].children, words, stack);
                stack.pop();
            }
        }

    }
}