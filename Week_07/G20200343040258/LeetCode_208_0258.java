class Trie {
    //顶节点
    private TrieNode root;

    //内部类
    private class TrieNode{
        //字典Node数组
        private TrieNode linksNode[];

        private final int leetterLen = 26;
        //是否是终点 用来判断字典是否是有该单词
        private boolean isEnd;

        public int getIndex(char ch){
            return ch - 'a';
        }

        public TrieNode(){
            linksNode = new TrieNode[leetterLen];
        }

        //向字母对应下标 插入node
        public void put(char ch,TrieNode node){
            linksNode[getIndex(ch)] = node;
        }
        //获取字母对应下标的TrieNode
        public TrieNode get(char ch){
           return linksNode[getIndex(ch)];
        }

        //判断 linksNode 数组 字母对应下标是否有Node
        public boolean containsKey(char ch){
                return linksNode[getIndex(ch)] != null;
        }

        //设置终点
        public void setEnd(){
            isEnd = true;
        }
        //是否终点
        public boolean isEnd(){
            return isEnd;
        }
    }

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    //插入字符串a-z组成
    public void insert(String word) {
        //往字典Node drill down
        TrieNode node = root;
        int strLen = word.length();
        for(int i = 0; i < strLen; i++){
            char curLetter = word.charAt(i);
            //字母下标赋值node
             //如果本身就存在 就不 需要创建
            if(node.get(curLetter) == null){
                node.put(curLetter,new TrieNode());
            }
            //node.put(curLetter,new TrieNode());
            node = node.get(curLetter);

            if(i == strLen - 1){
                node.setEnd();
            }
        }
    }
    
    /** Returns if the word is in the trie. */
    //查询改前缀树是否包含改单词
    public boolean search(String word) {
        //drill down 
        int strLen = word.length();
        TrieNode node = root;
        for(int i = 0; i < strLen; i++){
            char curLetter = word.charAt(i);
            TrieNode nextNode = node.get(curLetter);
            //null
            if(nextNode == null){
                return false;
            }
            //end
            if(i == strLen - 1 && nextNode.isEnd ){
                return true;
            }
            node = nextNode;
        }
        return false;
        
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
          //drill down 
        int strLen = prefix.length();
        TrieNode node = root;
        for(int i = 0; i < strLen; i++){
            char curLetter = prefix.charAt(i);
            TrieNode nextNode = node.get(curLetter);
            //null
            if(nextNode == null){
                return false;
            }
            node = nextNode;
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */