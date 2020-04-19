package com.logic;

import javafx.util.Pair;

import java.util.*;

/**
 * @Auther: welllu
 * @Date: 2020/4/5 12:40
 * @Description:
 */
public class LeeCode_127_0226 {
    //bfs
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        int L = beginWord.length();

        HashMap<String,ArrayList<String>> allWordsDict = new HashMap<> ();
        genetateAllWordsDict(allWordsDict, beginWord, wordList, L);

        //queue init and visited init
        Queue<Pair<String,Integer>> queue = new LinkedList<> ();
        queue.add(new Pair( beginWord,1 ));

        HashMap<String,Boolean> visiteds = new HashMap<>();
        visiteds.put(beginWord,true);

        //process node and related
        while (! queue.isEmpty()) {
            Pair<String,Integer> currentWordMap = queue.remove();
            String currentWord = currentWordMap.getKey ();
            int level = currentWordMap.getValue ();

            for (int i = 0; i < L; i ++) {
                String newWord = currentWord.substring(0,i) + '*' + currentWord.substring(i + 1, L);
                for (String dictWord: allWordsDict.getOrDefault(newWord, new ArrayList<String>()
                )) {
                    // 找到
                    if(dictWord.equals(endWord)) {
                        return level + 1;
                    }
                    if(!visiteds.containsKey(dictWord)) {
                        visiteds.put(dictWord, true);
                        queue.add(new Pair( dictWord,level + 1 ));
                    }
                }
            }
        }


        //other process

        return 0;
    }


    private void genetateAllWordsDict(HashMap<String,ArrayList<String>> allWordsDict,String beginWord,List<String> wordList, int L) {
        for(String word: wordList) {
            for (int i = 0; i < L; i ++) {
                String newWord = word.substring(0,i) + "*" + word.substring(i + 1, L);
                ArrayList<String> list = allWordsDict.getOrDefault(newWord, new ArrayList<String>());
                list.add(word);
                allWordsDict.put(newWord, list);
            }
        }
    }
}
