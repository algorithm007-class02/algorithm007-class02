package com.wxs.algorithm1.week07;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-04-23
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

 class LeetCode_212_0316 {


    public static void main(String[] args) {
        LeetCode_212_0316 findWords212 = new LeetCode_212_0316();

        char[][] board = new char[][]
                {
                        {'o', 'a', 'a', 'n'},
                        {'e', 't', 'a', 'e'},
                        {'i', 'h', 'k', 'r'},
                        {'i', 'f', 'l', 'v'}
                };


        String[] words = {"oath","pea","eat","rain"};


        List<String> words1 = findWords212.findWords(board, words);

        System.out.println(words1);

    }


    Set<String> set = new HashSet<>();

    public List<String> findWords(char[][] board, String[] words) {


        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        int row = board.length;
        int col = board[0].length;


        boolean[][] visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                dfs(board, visited, "", i, j, trie);
            }

        }

        return new ArrayList<>(set);

    }

    private void dfs(char[][] board, boolean[][] visited, String str, int row, int col, Trie trie) {

        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) return;

        if (visited[row][col]) return;

        str += board[row][col];

        if (!trie.startsWith(str)) return;

        if (trie.search(str)) set.add(str);

        visited[row][col] = true;

        dfs(board, visited, str, row - 1, col, trie);
        dfs(board, visited, str, row + 1, col, trie);
        dfs(board, visited, str, row, col - 1, trie);
        dfs(board, visited, str, row, col + 1, trie);

        visited[row][col] = false;

    }


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



    }

}
