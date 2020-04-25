
// 47. 全排列 II
// 解法： DFS

class Solution {
public:
	vector<vector<int>> permuteUnique(vector<int>& nums) {
		sort(nums.begin(),nums.end());
		vector<int> path(nums.size());
		vector<vector<int>> ans;
		dfs(nums,0,path,ans);
		return ans;
	}
	
	void dfs(const vector<int>& A,
			 int cur,vector<int>& path,
			 vector<vector<int>>& ans){
		if(cur==A.size()){
			ans.push_back(path);
		}else for(int i=0;i<A.size();++i){
			if(i && A[i] == A[i-1]) continue;
			int c=0;
			for(int j=0;j<A.size();++j) if(A[j] == A[i]) ++c;
			int d=0;
			for(int j=0;j<cur;++j) if(path[j] == A[i]) ++d;
			if(d < c){
				path[cur] = A[i];
				dfs(A,cur+1,path,ans);
			}
		}
	}
};
