package com.alang.learn.week4;

import java.util.*;

/***
 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：

 每次转换只能改变一个字母。
 转换过程中的中间单词必须是字典中的单词。
 说明:

 如果不存在这样的转换序列，返回 0。
 所有单词具有相同的长度。
 所有单词只由小写字母组成。
 字典中不存在重复的单词。
 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 示例 1:

 输入:
 beginWord = "hit",
 endWord = "cog",
 wordList = ["hot","dot","dog","lot","log","cog"]

 输出: 5

 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 返回它的长度 5。
 示例 2:

 输入:
 beginWord = "hit"
 endWord = "cog"
 wordList = ["hot","dot","dog","lot","log"]

 输出: 0

 解释: endWord "cog" 不在字典中，所以无法进行转换。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/word-ladder
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_127_0034 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(solution.ladderLength("hit", "cog", Arrays.asList(words)));
        System.out.println(solution.ladderLengthByDBFS("hit", "cog", Arrays.asList(words)));
        words = new String[]{"hot", "dot", "dog", "lot", "log"};
        System.out.println(solution.ladderLength("hit", "cog", Arrays.asList(words)));
        System.out.println(solution.ladderLengthByDBFS("hit", "cog", Arrays.asList(words)));
        words = new String[]{"hot", "dog"};
        System.out.println(solution.ladderLength("hot", "dog", Arrays.asList(words)));
        System.out.println(solution.ladderLengthByDBFS("hot", "dog", Arrays.asList(words)));
    }

    static class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            HashSet<String> wordSet = new HashSet<>(wordList);
            if (!wordSet.contains(endWord)) return 0;
            HashMap<String, ArrayList<String>> allConditions = new HashMap<>();
            generateAllConditionsMap(wordSet, allConditions, beginWord.length());
            LinkedList<String> queue = new LinkedList<>();
            queue.offer(beginWord);
            int level = 0;
            while (!queue.isEmpty()) {
                int count = queue.size();
                level++;
                for (int i = 0; i < count; i++) {
                    String cur = queue.poll();
                    wordSet.remove(cur);
                    HashSet<String> set = getConditionSet(cur);
                    for (String s : set) {
                        if (allConditions.containsKey(s)) {
                            for (String n : allConditions.get(s)) {
                                if (n.equals(endWord)) {
                                    return ++level;
                                }
                                if (wordSet.contains(n)) {
                                    queue.offer(n);
                                }
                            }
                        }
                    }
                }
            }
            return 0;
        }

        private HashSet<String> getConditionSet(String cur) {
            HashSet<String> set = new HashSet<>();
            char[] arr = cur.toCharArray();
            char temp;
            for (int j = 0; j < arr.length; j++) {
                temp = arr[j];
                arr[j] = '*';
                set.add(String.valueOf(arr));
                arr[j] = temp;
            }
            return set;
        }

        private void generateAllConditionsMap(HashSet<String> wordSet, HashMap<String, ArrayList<String>> allConditions, int length) {
            wordSet.forEach(word -> {
                for (int i = 0; i < length; i++) {
                    String newWord = word.substring(0, i) + "*" + word.substring(i + 1, length);
                    ArrayList<String> condition = allConditions.getOrDefault(newWord, new ArrayList<>());
                    allConditions.put(newWord, condition);
                    condition.add(word);
                }
            });
        }

        public int ladderLengthByDBFS(String beginWord, String endWord, List<String> wordList) {
            HashSet<String> wordSet = new HashSet<>(wordList);
            if (!wordSet.contains(endWord)) return 0;
            HashSet<String> start = new HashSet<>();
            HashSet<String> end = new HashSet<>();
            start.add(beginWord);
            end.add(endWord);
            int level = 1;
            while (!start.isEmpty() && !end.isEmpty()) {
                level++;
                wordSet.removeAll(start);
                HashSet<String> set = new HashSet<>();
                for (String word : start) {
                    char[] chars = word.toCharArray();
                    char temp;
                    String newWord;
                    for (int i = 0; i < chars.length; i++) {
                        temp = chars[i];
                        for (char c = 'a'; c < 'z'; c++) {
                            chars[i] = c;
                            newWord = String.valueOf(chars);
                            if (!wordSet.contains(newWord)) continue;
                            if (end.contains(newWord)) return level;
                            set.add(newWord);
                        }
                        chars[i] = temp;
                    }
                }
                if (end.size() < set.size()) {
                    start = end;
                    end = set;
                } else {
                    start = set;
                }
            }
            return 0;
        }
    }
}
