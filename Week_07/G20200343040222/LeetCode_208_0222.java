/**
 * 设计字典树
 */
public class LeetCode_208_0222 {
    class Trie {

        private TrieNode root;
        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        /**
         * 插入 时间复杂度为O(m), 空间复杂度为O(m) m为word键长
         * @param word
         */
        public void insert(String word) {
            TrieNode node = root;
            char[] chars = word.toCharArray();
            for (int i = 0 ; i < word.length(); i++) {
                char currentChar = chars[i];
                if (!node.containsKey(currentChar)) {
                    node.put(currentChar, new TrieNode());
                }
                node = node.get(currentChar);
            }
            node.setEnd();

        }

        /** Returns if the word is in the trie. */
        /**
         * 时间复杂度为O(m),空间复杂度为O(1) ,m 为 word 键长
         * @param word
         * @return
         */
        public boolean search(String word) {
            TrieNode node = searchPreFix(word);
            return node != null && node.isEnd();
        }


        /** Returns if there is any word in the trie that starts with the given prefix. */
        /**
         * 时间复杂度为O(m),空间复杂度为O(1) ,m 为 preFix键长
         * @param prefix
         * @return
         */
        public boolean startsWith(String prefix) {
            TrieNode node = searchPreFix(prefix);
            return node != null;
        }

        private TrieNode searchPreFix(String word) {
            TrieNode node = root;
            char[] chars = word.toCharArray();
            for (int i = 0; chars.length; i++) {
                char currentChar = chars[i];
                if (node.containsKey(currentChar)) {
                    node = node.get(currentChar);
                } else {
                    return null;
                }
            }
            return node;
        }

        public class TrieNode {

            private TrieNode[] links;

            private final int R = 26;

            private boolean isEnd;

            public TrieNode() {
                links = new TrieNode[R];
            }

            public boolean containsKey(char ch) {
                return links[ch - 'a'] != null;
            }

            public TrieNode get(char ch) {
                return links[ch - 'a'];
            }

            public void put(char ch, TrieNode node) {
                links[ch - 'a'] = node;
            }

            public void setEnd() {
                isEnd = true;
            }

            public boolean isEnd() {
                return isEnd;
            }

        }
    }


    /**
     * 优化字典树
     */
    class TrieRe {

        private boolean endString = false;

        private TrieRe[] node = new TrieRe[26];

        public TrieRe() {}

        public void insert(String word){
            TrieRe root = this;
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (root.node[chars[i] - 'a'] == null) {
                    root.node[chars[i] - 'a'] = new TrieRe();
                }
                root = root.node[chars[i] - 'a'];
            }
            root.endString = true;
        }

        public boolean search(String word){
            TrieRe endTrie = searchPreFix(word);
            return endTrie != null && endTrie.endString;
        }

        public boolean startsWith(String prefix) {
            TrieRe endTrie = searchPreFix(prefix);
            return endTrie != null;
        }

        public TrieRe searchPreFix(String word) {
            TrieRe root = this;
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (root.node[chars[i] - 'a'] == null) {
                    return null;
                }
                root = root.node[chars[i] - 'a'];
            }
            return root;
        }
    }

}