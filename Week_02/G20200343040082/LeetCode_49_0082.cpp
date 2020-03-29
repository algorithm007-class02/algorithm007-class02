/**

49. 字母异位词分组

给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。


输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]


所有输入均为小写字母。
不考虑答案输出的顺序。

*/

#include <vector>
#include <iostream>
#include <unordered_map>
#include <algorithm>

using namespace std;

// key 数据结构的组合设计

class Solution {
public:
	vector<vector<string>> groupAnagrams(vector<stirng>& strs) {
		vector<vector<string>> ret;

		unordered_map<string, vector<string>> strMap;

		for (auto& s : strs) {
			string s_t = s;
			sort(s.begin(), s.end());
			strMap[s].emplace_back[s_t];
		}

		for (auto& e : strMap) {
			ret.emplace_back(e.second);
		}

		return ret;
	}
};