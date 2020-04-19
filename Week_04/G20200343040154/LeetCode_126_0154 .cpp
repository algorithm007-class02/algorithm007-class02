// 126. 单词接龙 II
// https://leetcode-cn.com/problems/word-ladder-ii/description/

// 解法：BFS
class Solution {
public:
	// find words with one char different in dict
	// hot->[dot,lot]
	// 4.计算当word仅改变其中一个字母时得到的词，在wordlist里是否有
	vector<string> addWord(string word, unordered_set<string>& wordlist) {
		vector<string> res;
		for (int i=0; i< word.size(); i++) {
			char s = word[i];
			for (char c='a'; c<='z'; c++) {
				word[i] = c;
				if (wordlist.count(word)) res.push_back(word);
			}
			word[i] = s;
		}
		return res;
	}

	vector<vector<string>> findLadders(string beginWord, string endWord, vector<string>& wordList) {
		// 1. 判断极端异常情况
		if (beginWord.empty() || endWord.empty() || wordList.empty()) return {};
		if (find(wordList.begin(), wordList.end(), endWord) == wordList.end()) return {};

		// 2.初始化BFS
		unordered_set<string> visit;
		vector<vector<string>> ans;
		queue<vector<string>> q;
		unordered_set<string> wordlist(wordList.begin(),wordList.end());
		q.push({beginWord});
		bool flag= false; //to see if we find shortest path

		// 3.执行BFS
		while(!q.empty()) {
			int size = q.size();
			for (int i = 0; i< size; i++) {
				vector<string> cur = q.front();
				q.pop();
				vector<string> newadd = addWord(cur.back(),wordlist);
				for (int j=0; j<newadd.size(); j++) {
					vector<string> newline(cur.begin(),cur.end());
					newline.push_back(newadd[j]);
					if (newadd[j] == endWord) {
						flag = true;
						ans.push_back(newline);
					}
					visit.insert(newadd[j]);
					q.push(newline);
				}
			}
			if (flag) break;
			for (auto it=visit.begin(); it!=visit.end(); it++) wordlist.erase(*it);
			visit.clear();
		}
		return ans;
	}
};

