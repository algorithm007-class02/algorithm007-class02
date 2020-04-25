//�ݹ鷨1
class Solution {
public:
    vector<vector<int>> permuteUnique(vector<int>& nums) {
        vector<int> tmp;
        vector<bool> visited(nums.size(), false);
        sort(nums.begin(), nums.end());
        recursion(nums, tmp, visited);
        return res;
    }

    void recursion(vector<int>& nums, vector<int>& tmp, vector<bool>& visited) {
        if (tmp.size() == nums.size()) {
            res.push_back(tmp);
            return;
        }

        for (int i = 0; i < nums.size(); i++) {
            if (!visited[i]) {
                tmp.push_back(nums[i]);
                visited[i] = true;
                recursion(nums, tmp, visited);
                visited[i] = false;
                tmp.pop_back();

                while (i < nums.size() - 1 && nums[i] == nums[i+1]) {
                    i++;
                }
            }
        }
    }
    vector<vector<int>> res;
};

//�ݹ鷨2
class Solution {
public:
    vector<vector<int>> permuteUnique(vector<int>& nums) {
        vector<vector<int>> res;
        sort(nums.begin(), nums.end());
        recursion(nums, 0, nums.size(), res);
        return res;
    }

    void recursion(vector<int> nums, int i, int j, vector<vector<int>>& res) {
        if (i == j - 1) {
            res.push_back(nums);
            return;
        }

        for (int k = i; k < j; k++) {
            if (k != i && nums[k] == nums[i])
                continue;
            swap(nums[k], nums[i]);
            recursion(nums, i+1, j, res);
        }
    }
};