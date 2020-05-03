// 208. 实现 Trie (前缀树)
// https://leetcode-cn.com/problems/implement-trie-prefix-tree/#/description

// 面试要求：熟练背下来，默写下来，烂熟于心即可 => 目标：做到随时能写出来。

// memset()函数  http://c.biancheng.net/cpp/html/157.html
// memset() 函数用来将指定内存的前n个字节设置为特定的值，其原型为：
//   void * memset( void * ptr, int value, size_t num );
// 注意：字符数组是可以被修改的，字符串是只读的，不能被修改，而 memset() 又必须修改 str，所以不能将 char str[] = "http://c.biancheng.net"; 声明为 char *str = "http://c.biancheng.net";，否则运行时会报错。

class Trie {
private:
	// 指定节点是对应键的结尾还是只是键前缀
	bool isEnd;
	// 最多26个指向子节点的链接，其中每个链接对应字母表数据集中的一个字母，这里取26个英文字母。
	Trie* next[26];
public:
	/** Initialize your data structure here. */
	// 构造函数
	Trie() {
		isEnd = false;
		// memset(next, 0, sizeof(next));
		// 等同于：
		for (int i=0;i<26;i++) {
			next[i] = nullptr;
		}
	}
	
	/** Inserts a word into the trie. */
	// 插入键 时间复杂度O(m)，m为键长。空间复杂度O(m)，最坏的情况下新插入的键没有公共前缀。
	// 通过搜索Trie树来插入键。从根开始搜索它对应于第一个键字符的链接。
	void insert(string word) {
		// 用于指向每一层节点，进行搜索的操作。
		Trie* node = this;
		// 遍历插入键的每一个字符
		for (char c: word) {
			// 如果链接不存在，创建一个新节点，并将它与父节点的链接相连，该链接与当前的键字符相匹配
			if (node->next[c-'a'] == NULL) {
				node->next[c-'a'] = new Trie();
			}
			 // 链接存在，沿着链接移动到树的下一个子层。算法继续搜索下一个键字符
			node = node->next[c-'a'];
		}
		// 直到到达键的最后一个字符，然后将当前节点标记为结束节点。此时的当前节点已经移动到键的最后字符所在的节点
		node->isEnd = true;
	}
	
	/** Returns if the word is in the trie. */
	 // 查找键 时间复杂度O(m)，最坏的情况下m为键长。空间复杂度O(1)
	bool search(string word) {
		Trie* node = this;
		for (char c: word) {
			node = node->next[c-'a']; // 逐层遍历node，然后更新node
			// 如果链接不存在，查找失败
			if (node == NULL) {
				return false;
			}
		}
		// 直到到达最后一个字符，返回该键字符节点的isWord，如果为false，待查键是Trie树中另一个键的前缀。
		return node->isEnd;
	}
	
	/** Returns if there is any word in the trie that starts with the given prefix. */
	// 查找Trie树中的键前缀
	bool startsWith(string prefix) {
		Trie* node = this;
		for (char c : prefix) {
			node = node->next[c-'a'];
			if (node == NULL) {
				return false;
			}
		}
		// 直到到达最后一个字符，由于是查找前缀，而不是整个键，所以返回true
		return true;
	}
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */