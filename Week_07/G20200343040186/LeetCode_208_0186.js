/**
 * 题目：实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 * 例子：
 *      Trie trie = new Trie();
        trie.insert("apple");
        trie.search("apple");   // 返回 true
        trie.search("app");     // 返回 false
        trie.startsWith("app"); // 返回 true
        trie.insert("app");   
        trie.search("app");     // 返回 true
 */

class Trie {
  constructor(val = "") {
    this.val = val;
    this.children = {};
    this.isTerm = false;
  }

  insert(word) {
    let current = this;
    for (let char of word) {
      if (!current.children[char]) {
        current.children[char] = new Trie(char);
      }
      current = current.children[char];
    }
    current.isTerm = true;
  }

  search(word, skipTerm = false) {
    let current = this;
    for (let char of word) {
      if (!current.children[char]) {
        return false;
      }
      current = current.children[char];
    }
    return skipTerm ? true : current.isTerm;
  }

  startsWith(prefix) {
    return this.search(prefix, true);
  }
}
