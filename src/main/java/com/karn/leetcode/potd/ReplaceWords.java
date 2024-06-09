package com.karn.leetcode.potd;


import java.util.List;

public class ReplaceWords {
    public static void main(String[] args) {
        Trie trie=new Trie();
        trie.addWord("a");
        trie.addWord("bad");
        System.out.println(trie.getPreWord("badass"));
    }


    public String replaceWords(List<String> dictionary, String sentence){
        Trie trie = new Trie();
        for (String s : dictionary) {
            trie.addWord(s);
        }
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String preWord = trie.getPreWord(words[i]);
            if(!"".equals(preWord)){
                words[i] = preWord;
            }
        }
        return String.join(" ",words);
    }

    /**
     * Crete a structure
     * with Node[] as children and end.
     *
     * When you add a word "ashish"
     *          [ 'a', null, null ......,null]
     *               \
     * [null, null,..'s'...null,null]  & ends is false
     *              /
     *    [null,..'h'...null,null] & ends is false
     *               \
     * [null, null,..'i'...null,null] & ends is false
     *                 \
     *    [null, null,..'s'...null,null] & ends is false
     *                  /
     *       [null,..'h'...null,null] & ends is false
     *               |
     *     [null,....null,null]  & ends is true
     *
     *
     * On top of this, when we add "a"
     *
     *                       [ 'a', null, null ......,null]
     *                          /\
     *   [null,..,null] &end=true \
     *        [null, null,..'s'...null,null]  & ends is false
     *                     /
     *           [null,..'h'...null,null] & ends is false
     *                      \
     *        [null, null,..'i'...null,null] & ends is false
     *                        \
     *           [null, null,..'s'...null,null] & ends is false
     *                         /
     *              [null,..'h'...null,null] & ends is false
     *                      |
     *            [null,....null,null]  & ends is true
     *
     *
     *
     *
     * */
    static class Trie {
        Node root;

        Trie() {
            this.root = new Node();
        }

        public void addWord(String word) {
            Node node = this.root;
            char[] charArray = word.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                if(node.children[charArray[i] - 'a'] == null){
                    node.children[charArray[i] - 'a'] = new Node();
                }
                Node child = node.children[charArray[i] - 'a'];

                node = child;
                if (i == charArray.length - 1) {
                    node.end = true;
                }

            }
        }

        public boolean hasWord(String word) {
            char[] charArray = word.toCharArray();
            Node node = this.root;
            for (int i = 0; i < charArray.length; i++) {
                if(node.children[charArray[i]-'a']==null){
                    return false;
                }
                node = node.children[charArray[i]-'a'];
            }
            return node.end;
        }
        public String getPreWord(String word) {
            char[] charArray = word.toCharArray();
            Node node = this.root;
            StringBuilder sb= new StringBuilder();
            for (int i = 0; i < charArray.length; i++) {
                if(node.children[charArray[i]-'a']==null){
                    return "";
                }
                sb.append(charArray[i]);
                node = node.children[charArray[i]-'a'];
                if(node.end){
                    return sb.toString();
                }
            }
            return "";
        }
    }

    static class Node {
        Node[] children = new Node[26];
        boolean end;

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < children.length; i++) {
                if (children[i] != null) {
                    sb.append((char) ('a' + i)).append(" ");
                }
            }
            return sb.toString();
        }
    }
}
