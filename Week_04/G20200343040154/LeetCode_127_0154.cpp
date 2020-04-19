//127. 单词接龙
//https://leetcode-cn.com/problems/word-ladder/

// 解法1：BFS 
// 广度优先搜索求解，注意这里我们选用unordered_set<string> visited用来标记单词是否被访问过，如果已经被访问过，说明已经有对应路径存在，因此跳过访问
class Solution {
public:
	int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
		unordered_set<string> dict(wordList.begin(), wordList.end());
		unordered_set<string> visited;
		queue<string> q;
		visited.insert(beginWord);
		q.push(beginWord);
		int res=1;

		while(!q.empty()) {
			int size = q.size();
			while(size--) {
				auto t = q.front();
				q.pop();
				for (int i=0; i<t.size(); i++) {
					string word = t;
					for (auto ch='a'; ch<='z'; ch++) {
						word[i]=ch;
						if (!dict.count(word) || visited.count(word)) continue;
						if (word == endWord) return res+1;
						visited.insert(word);
						q.push(word);
					}
				}
			}
			res++;
		}
		return 0;
	}
};


// 解法2:BFS
// 【此方法未能正确输出，待调试】
//class Solution {
//public:
//    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
//        // 1.判读极端情况
//		if (beginWord.empty() || endWord.empty() || wordList.empty()) return 0;
//		if (find(wordList.begin(), wordList.end(), endWord) == wordList.end()) return 0; // 基因不在基因库中
//
//		// 2.初始化BFS
//		vector<int> visit(wordList.size(), 0);
//		queue<string> q;
//		int step = 1;
//		q.push(beginWord);
//
//		// 3.进行BFS
//		while(!q.empty()) {
//            ++step;
//			int n = q.size(); //确定每次bfs的宽度
//			for(int i =0; i<n; i++) {
//				string &tmp = q.front(); //获得队头元素
//				q.pop();
//				for (int j = 0; j<wordList.size(); j++) {
//					if (visit[j] == 0) {
//						int diff = 0;
//						for (int k=0; k<wordList[j].size();k++) {
//							if (tmp[k] != wordList[j][k]) diff++;
//						}
//						if (diff == 1) {
//							if (wordList[j] == endWord) {
//                                return ++step;
//                            }
//							visit[j] = 1;
//							q.push(wordList[j]);
//						}
//					}
//				}
//			}
//		}
//		return 0;
//    }
//};


