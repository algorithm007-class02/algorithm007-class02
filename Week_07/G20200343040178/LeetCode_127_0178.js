/*
 * @Author: mingxing.huang
 * @Date: 2020-04-25 13:59:48
 */
/**
 * 单词接龙
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {number}
 */
var ladderLength = function (beginWord, endWord, wordList) {
    // BFS
    if (!endWord || !wordList.includes(endWord)) {
        return 0;
    }
    // 将wordList单词，进行处理，找出通用词，并且归类
    // 例如：hit,hot --> h*t: [hit, hot]
    let len = beginWord.length;
    let dict = {};
    for (let word of wordList) {
        for (let i = 0; i < len; i++) {
            let newWord = word.substring(0, i) + '*' + word.substring(i + 1);
            if (!dict[newWord]) {
                dict[newWord] = [];
            }
            dict[newWord].push(word);
        }
    }
    let q = [[beginWord, 1]];
    let visited = [beginWord];
    while (q.length > 0) {
        let cur = q.shift();
        let curWord = cur[0];
        let curLen = cur[1];
        for (let i = 0; i < len; i++) {
            let newWord = curWord.substring(0, i) + '*' + curWord.substring(i + 1);
            if (newWord in dict) {
                for (let w of dict[newWord]) {
                    if (w === endWord) {
                        return curLen + 1;
                    }
                    if (!visited.includes(w)) {
                        visited.push(w);
                        q.push([w, curLen + 1]);
                    }
                }
            }
        }
    }
    return 0;
};