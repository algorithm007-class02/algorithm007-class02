//给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换
//需遵循如下规则： 
//
// 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典中的单词。 
// 
//
// 说明: 
//
// 
// 如果不存在这样的转换序列，返回一个空列表。 
// 所有单词具有相同的长度。 
// 所有单词只由小写字母组成。 
// 字典中不存在重复的单词。 
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。 
// 
//
// 示例 1: 
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出:
//[
//  ["hit","hot","dot","dog","cog"],
//  ["hit","hot","lot","log","cog"]
//]
// 
//
// 示例 2: 
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: []
//
//解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。 
// Related Topics 广度优先搜索 数组 字符串 回溯算法


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) return result;

        Map<String,List<String>> mapTree = new HashMap<>();
        Set<String> begin = new HashSet<>();
        Set<String> end = new HashSet<>();
        begin.add(beginWord);
        end.add(endWord);

        if (buildTree(words,begin,end,mapTree,true)) {
            dfs(result,mapTree,beginWord,endWord,new LinkedList<>());
        }
        return result;
    }
    boolean buildTree(Set<String> words,Set<String> begin,Set<String> end,Map<String,List<String>> mapTree,boolean isFront) {
        if (begin.size() == 0) return false;
        if (begin.size() > end.size()) return buildTree(words,end,begin,mapTree,!isFront);

        words.removeAll(begin);
        boolean isMeet = false;
        Set<String> nextLevel = new HashSet<>();
        for (String word : begin) {
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char temp = chars[i];
                for (char ch = 'a';ch <= 'z';ch++) {
                    chars[i] = ch;
                    String str = String.valueOf(chars);
                    if (words.contains(str)) {
                        nextLevel.add(str);
                        String key = isFront ? word : str;
                        String nextWord = isFront ? str : word;
                        if (end.contains(str)) isMeet = true;
                        if (!mapTree.containsKey(key)) mapTree.put(key,new ArrayList<>());
                        mapTree.get(key).add(nextWord);
                    }
                }
                chars[i] = temp;
            }
        }
        if (isMeet) return true;
        return buildTree(words,nextLevel,end,mapTree,isFront);
    }
    void dfs(List<List<String>> result,Map<String,List<String>> mapTree,String beginWord,String endWord,LinkedList<String> list) {
        list.add(beginWord);
        if (beginWord.equals(endWord)) {
            result.add(new ArrayList<>(list));
            list.removeLast();
            return;
        }
        if (mapTree.containsKey(beginWord)) {
            for (String word : mapTree.get(beginWord))
                dfs(result,mapTree,word,endWord,list);
        }
        list.removeLast();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
