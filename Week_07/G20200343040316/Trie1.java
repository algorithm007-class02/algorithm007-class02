package com.wxs.algorithm1.week07;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-04-25
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class Trie1 {



    private Trie1Node root;

    public Trie1(){
        root = new Trie1Node();
    }




    public void insert(String word){

        Trie1Node node = root;

        for (int i = 0; i < word.length(); i++) {

            char c = word.charAt(i);

            if(!node.containsKey(c)){

                node.put(c,node);
            }

            node = node.get(c);

        }

        node.setEnd();

    }

    public boolean search(String word){

        Trie1Node trie1Node = searchPrefix(word);
        return trie1Node != null && trie1Node.isEnd;
    }


    public Trie1Node searchPrefix(String word){

        Trie1Node node = root;

        for (int i = 0; i < word.length(); i++) {
            if(node.containsKey(word.charAt(i))){
                node = node.get(word.charAt(i));
            }else {
                return null;
            }

        }
        return node;
    }





    class Trie1Node{

        private Trie1Node[] links;
        private boolean isEnd;


        private final int len = 26;

        public Trie1Node(){
            this.links = new Trie1Node[len];
        }


        public Trie1Node get(char ch){
            return links[ch - 'a'];
        }

        public void put(char ch,Trie1Node node){
            links[ch - 'a'] = node;
        }

        public boolean containsKey(char ch){

            return links[ch-'a'] != null;

        }

        public void setEnd(){
            this.isEnd = true;
        }

        public boolean isEnd(){
            return isEnd;
        }


    }


}
