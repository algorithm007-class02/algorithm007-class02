package com.wxs.algorithm1.week07;/*
package com.wxs.algorithm.week07;

*/
/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-04-23
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 *//*


class Trie {

    private TrieNode root;

    public Trie(){

        root = new TrieNode();
    }


    public void insert(String word){

        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {

            char c = word.charAt(i);
            if(!node.containsKey(c)){
                node.put(c,new TrieNode());
            }
            node = node.get(c);
        }

        node.setEnd();

    }


    public boolean search(String word){

        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    private TrieNode searchPrefix(String word) {


        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {

            if(node.containsKey(word.charAt(i))){
                node = node.get(word.charAt(i));
            }else {
                return null;
            }

        }
        return node;
    }


    public boolean startsWith(String prefix){


        TrieNode node = searchPrefix(prefix);
        return node != null;
    }


    class TrieNode {


        private TrieNode[] links;

        private boolean isEnd;


        private final int len = 26;

        public TrieNode() {

            links = new TrieNode[len];
        }


        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;

        }


        public TrieNode get(char ch){

            return links[ch - 'a'];
        }


        public void put(char ch,TrieNode node){

            links[ch -'a'] = node;
        }

        public void  setEnd(){
            this.isEnd = true;
        }

        public boolean isEnd(){
            return this.isEnd;
        }



    }




}*/
