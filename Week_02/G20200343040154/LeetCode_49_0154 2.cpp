// 解法1: map + 二维数组，时间：O(n)，空间O(n)
// 处理：利用哈希表键唯一性原理，每个键对应唯一一个数组；遍历完数组后，根据键把值赋值到二维数组中。
class Solution {
public:
	vector<vector<string>> groupAnagrams(vector<string>& strs) {
		vector<vector<string>> response;
		unordered_map<string, vector<string>> map;
		for (auto s : strs) {
			string temp = s;
			sort(temp.begin(), temp.end());
			map[temp].push_back(s);
		}
//		unordered_map<string, vector<string>>::iterator it;
//		for(it = map.begin(); it != map.end(); it++) {
//			response.push_back(it->second);
//		}
		for (auto it : map) {
			response.push_back(it.second);
		}
		return response;
	}
};