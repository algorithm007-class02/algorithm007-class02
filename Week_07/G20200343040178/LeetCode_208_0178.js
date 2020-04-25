/*
 * @Author: mingxing.huang
 * @Date: 2020-04-23 18:05:41
 */
/**
 * 实现 Trie (前缀树)
 * Initialize your data structure here.
 */
class Node {
    constructor() {
        this.children = Array(26);
        this.isEnd = false;
    }
}
var Trie = function () {
    this.root = new Node();
};

/**
 * Inserts a word into the trie. 
 * @param {string} word
 * @return {void}
 */
Trie.prototype.insert = function (word) {
    let cur = this.root;
    for (const c of word) {
        const i = this._char2Num(c);
        if (cur.children[i] === undefined) {
            cur.children[i] = new Node();
        }
        cur = cur.children[i];
    }
    cur.isEnd = true;
};

/**
 * Returns if the word is in the trie. 
 * @param {string} word
 * @return {boolean}
 */
Trie.prototype.search = function (word) {
    let cur = this.root;
    for (let c of word) {
        const i = this._char2Num(c);
        if (cur.children[i] !== undefined) {
            cur = cur.children[i];
        } else {
            return false;
        }
    }
    return cur.isEnd;
};

/**
 * Returns if there is any word in the trie that starts with the given prefix. 
 * @param {string} prefix
 * @return {boolean}
 */
Trie.prototype.startsWith = function (prefix) {
    let cur = this.root;
    for (let c of prefix) {
        const i = this._char2Num(c);
        if (cur.children[i] !== undefined) {
            cur = cur.children[i];
        } else {
            return false;
        }
    }
    return true;
};

/**
 * 将字符的ASCII转成基于0的数字
 * @param {string} char（a-z）
 * @return {number}
 */
Trie.prototype._char2Num = function (char) {
    return char.charCodeAt() - 97;
}

/**
 * Your Trie object will be instantiated and called as such:
 * var obj = new Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */