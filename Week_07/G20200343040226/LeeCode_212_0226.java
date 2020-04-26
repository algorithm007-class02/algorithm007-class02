package com.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Auther: welllu
 * @Date: 2020/4/26 20:56
 * @Description:
 */
public class LeeCode_212_0226 {
    ArrayList<String> result = new ArrayList <String> (  );
    char[][] board = null;
    public List<String> findWords(char[][] board, String[] words) {

        this.board = board;

        TireNode root = new TireNode ();
        for(String word: words) {
            TireNode node = root;
            for(Character letter: word.toCharArray ()) {
                if(node.children.containsKey ( letter )) {
                    node = node.children.get ( letter );
                }else{
                    TireNode newNode = new TireNode ();
                    node.children.put(letter,newNode );
                    node = newNode;
                }
            }
            node.word = word;
        }

        for(int row = 0; row < board.length; row ++) {
            for(int col = 0; col < board[0].length; col ++) {
                if(root.children.containsKey ( board[row][col] )) {
                    backtracking(row,col,root);
                }
            }
        }

        return result;
    }

    private void backtracking(int row, int col, TireNode parent) {
        Character letter = this.board[row][col];
        TireNode currNode = parent.children.get ( letter );

        if(currNode.word != null) {
            this.result.add ( currNode.word );
            currNode.word = null;
        }

        this.board[row][col] = '#';

        int[] dx = {-1,0,1,0};
        int[] dy = {0,-1,0,1};

        for(int i = 0; i < 4; i ++) {
            int newRow = row + dx[i];
            int newCol = col + dy[i];
            if(newRow < 0 || newRow >= this.board.length ||
                    newCol < 0 || newCol >= this.board[0].length) {
                continue;
            }

            if(currNode.children.containsKey ( this.board[newRow][newCol] )) {
                backtracking ( newRow,newCol,currNode );
            }

        }

        this.board[row][col] = letter;

        if(currNode.children.isEmpty ()) {
            parent.children.remove ( letter );
        }
    }


}


class TireNode {
    HashMap<Character,TireNode> children = new HashMap <> (  );
    String word = null;
    public TireNode(){}
}