package com.logic;

import java.util.*;

/**
 * @Auther: welllu
 * @Date: 2020/4/5 15:40
 * @Description:
 */
public class LeeCode_126_0226 {

    public List <List <String>> findLadders(String beginWord, String endWord, List <String> wordList) {
        // 结果集
        List <List <String>> res = new ArrayList <> ();
        Set <String> distSet = new HashSet <> ( wordList );
        // 字典中不包含目标单词
        if (!distSet.contains ( endWord )) {
            return res;
        }
        // 已经访问过的单词集合：只找最短路径，所以之前出现过的单词不用出现在下一层
        Set <String> visited = new HashSet <> ();
        // 累积每一层的结果队列
        Queue <List <String>> queue = new LinkedList <> ();
        List <String> list = new ArrayList <> ( Arrays.asList ( beginWord ) );
        queue.add ( list );
        visited.add ( beginWord );
        // 是否到达符合条件的层：如果该层添加的某一单词符合目标单词，则说明截止该层的所有解为最短路径，停止循环
        boolean flag = false;
        while (!queue.isEmpty () && !flag) {
            // 上一层的结果队列
            int size = queue.size ();
            // 该层添加的所有元素：每层必须在所有结果都添加完新的单词之后，再将这些单词统一添加到已使用单词集合
            // 如果直接添加到 visited 中，会导致该层本次结果添加之后的相同添加行为失败
            // 如：该层遇到目标单词，有两条路径都可以遇到，但是先到达的将该单词添加进 visited 中，会导致第二条路径无法添加
            Set <String> subVisited = new HashSet <> ();
            for (int i = 0; i < size; i++) {
                List <String> path = queue.poll ();
                // 获取该路径上一层的单词
                String word = path.get ( path.size () - 1 );
                char[] chars = word.toCharArray ();
                // 寻找该单词的下一个符合条件的单词
                for (int j = 0; j < chars.length; j++) {
                    char temp = chars[j];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[j] = ch;
                        if (temp == ch) {
                            continue;
                        }
                        String str = new String ( chars );
                        // 符合条件：在 wordList 中 && 之前的层没有使用过
                        if (distSet.contains ( str ) && !visited.contains ( str )) {
                            // 生成新的路径
                            List <String> pathList = new ArrayList <> ( path );
                            pathList.add ( str );
                            // 如果该单词是目标单词：将该路径添加到结果集中，查询截止到该层
                            if (str.equals ( endWord )) {
                                flag = true;
                                res.add ( pathList );
                            }
                            // 将该路径添加到该层队列中
                            queue.add ( pathList );
                            // 将该单词添加到该层已访问的单词集合中
                            subVisited.add ( str );
                        }
                    }
                    chars[j] = temp;
                }
            }
            // 将该层所有访问的单词添加到总的已访问集合中
            visited.addAll ( subVisited );
        }
        return res;
    }


    public List <List <String>> findLadders1(String beginWord, String endWord, List <String> wordList) {
        // 结果
        List <List <String>> result = new ArrayList <> ();

        Set <String> words = new HashSet <> ( wordList );
        if (!words.contains ( endWord )) {
            return result;
        }

        // 每个单词可达的下层关系
        Map <String, List <String>> mapTree = new HashMap <> ();
        Set <String> begin = new HashSet <> ();
        Set <String> end = new HashSet <> ();
        begin.add ( beginWord );
        end.add ( endWord );
        if (buildTree ( words, begin, end, mapTree, true )) {
            dfs ( result, mapTree, beginWord, endWord, new LinkedList <String> () );
        }
        return result;
    }

    // 双向bfs，构建每个单词的层次关系
    private boolean buildTree(Set<String> words, Set<String> begin, Set<String> end, Map<String, List<String>> mapTree, boolean isFront) {
        if (begin.size () == 0) return false;
        // 始终以少的进行探索
        if (begin.size () > end.size ()) {
            return buildTree ( words,end,begin,mapTree,!isFront );
        }

        // queue init and visited init
        // 去除已访问单词
        words.removeAll ( begin );
        // 标记本次是否已到达目标单词
        boolean isMeet = false;
        // 记录本次访问的单词
        Set<String> nextLevel = new HashSet <> (  );
        // process node and related
        for(String word: begin) {
            char[] chars = word.toCharArray ();
            for(int i = 0; i < chars.length; i ++) {
                // 任选一个字符，替换成'a'~'z'的任意字符
                char temp = chars[i];
                for(char ch = 'a'; ch <= 'z'; ch ++) {
                    chars[i] = ch;
                    String str = String.valueOf ( chars );
                    if(words.contains ( str )) {
                        nextLevel.add ( str );
                        // 根据访问关系，添加层次对应关系，上下或者，下上
                        String key = isFront ? word: str;
                        String nextWord = isFront ? str: word;
                        // 判断是否预见目标单词
                        if(end.contains ( str )) {
                            isMeet = true;
                        }
                        if(!mapTree.containsKey ( key )) {
                            mapTree.put(key,new ArrayList <> (  ));
                        }
                        mapTree.get ( key ).add ( nextWord );
                    }
                }
                // 还原本次单词
                chars[i] = temp;
            }
        }

        if(isMeet) {
           return true;
        }

        // other process work

        return buildTree ( words,nextLevel,end,mapTree,isFront );
    }
    //DFS:组合路径
    private void dfs(List<List<String>> result, Map<String, List<String>> mapTree, String beginWord, String endWord, LinkedList<String> list) {
        list.add ( beginWord );
        // 1.terminater or visited
        if(beginWord.equals ( endWord )) {
            result.add ( new ArrayList <> ( list ) );
            list.removeLast ();
            return;
        }
        // 2.process current node

        // 3.sub nodes
        if(mapTree.containsKey ( beginWord )) {
            for(String word: mapTree.get ( beginWord )) {
                dfs(result,mapTree,word,endWord,list);
            }
        }

        list.removeLast ();
    }


}