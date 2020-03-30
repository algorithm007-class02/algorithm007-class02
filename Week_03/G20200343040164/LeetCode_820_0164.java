//给定一个单词列表，我们将这个列表编码成一个索引字符串 S 与一个索引列表 A。 
//
// 例如，如果这个列表是 ["time", "me", "bell"]，我们就可以将其表示为 S = "time#bell#" 和 indexes = [0,
// 2, 5]。 
//
// 对于每一个索引，我们可以通过从字符串 S 中索引的位置开始读取字符串，直到 "#" 结束，来恢复我们之前的单词列表。 
//
// 那么成功对给定单词列表进行编码的最小字符串长度是多少呢？ 
//
// 
//
// 示例： 
//
// 输入: words = ["time", "me", "bell"]
//输出: 10
//说明: S = "time#bell#" ， indexes = [0, 2, 5] 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 2000 
// 1 <= words[i].length <= 7 
// 每个单词都是小写字母 。 
// 
//


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumLengthEncoding(String[] words) {
        int len = 0;
        Trie trie = new Trie();
        Arrays.sort(words,(s1,s2) -> s2.length() - s1.length() );
        for ( String word : words ) {
            len += trie.insert(word);
        }
        return len;
    }
}

class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    public int insert(String word) {
        TrieNode cur = root;
        boolean isNew = false;
        for ( int i = word.length() - 1; i >= 0; i-- ) {
            int index = word.charAt(i) - 'a';
            if ( cur.children[index] == null ) {
                isNew = true;
                cur.children[index] = new TrieNode();
            }
            cur = cur.children[index];
        }
        return isNew ? word.length() + 1 : 0;
    }
}

class TrieNode {
    char val;
    TrieNode[] children = new TrieNode[26];

    public TrieNode() {}
}
//leetcode submit region end(Prohibit modification and deletion)
