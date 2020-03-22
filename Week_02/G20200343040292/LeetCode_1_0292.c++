//暴力法 时间复杂度：O(n的平方) 空间复杂度：O(1)
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {   
        int len = nums.size();

        for (int i = 0; i < nums.size() - 1; i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                if (nums[i] + nums[j] == target)
                    return {i, j};
            }
        }
        return {};
    }   
};

//两遍哈希 时间复杂度：O(n) 空间复杂度：O(n)
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {   
        unordered_map<int, int> m;
        for (int i = 0; i < nums.size(); i++) {
            m[nums[i]] = i;
        }

        for (int i = 0; i < nums.size(); i++) {
            if (m.find(target-nums[i]) != m.end() && m[target-nums[i]] != i) // 哈希表中存在键值并且不为i，返回下标(先返回当前下标，再返回匹配到的下标)
                return {i, m[target-nums[i]]};
        }
        return {};
    }   
};


//一遍哈希 时间复杂度：O(n) 空间复杂度：O(n)
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {   
        unordered_map<int, int> m;

        for (int i = 0; i < nums.size(); i++) {
            if (m.find(target-nums[i]) != m.end()) // 哈希表中存在键值，
                return {m[target-nums[i]], i};		//返回下标(因为i为较大的元素，此时添加进去的键值都还小于i，所以i在后面)
            m[nums[i]] = i; //向哈希表中添加元素
        }
        return{};
    }   
};