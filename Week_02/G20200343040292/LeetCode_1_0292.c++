//������ ʱ�临�Ӷȣ�O(n��ƽ��) �ռ临�Ӷȣ�O(1)
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

//�����ϣ ʱ�临�Ӷȣ�O(n) �ռ临�Ӷȣ�O(n)
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {   
        unordered_map<int, int> m;
        for (int i = 0; i < nums.size(); i++) {
            m[nums[i]] = i;
        }

        for (int i = 0; i < nums.size(); i++) {
            if (m.find(target-nums[i]) != m.end() && m[target-nums[i]] != i) // ��ϣ���д��ڼ�ֵ���Ҳ�Ϊi�������±�(�ȷ��ص�ǰ�±꣬�ٷ���ƥ�䵽���±�)
                return {i, m[target-nums[i]]};
        }
        return {};
    }   
};


//һ���ϣ ʱ�临�Ӷȣ�O(n) �ռ临�Ӷȣ�O(n)
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {   
        unordered_map<int, int> m;

        for (int i = 0; i < nums.size(); i++) {
            if (m.find(target-nums[i]) != m.end()) // ��ϣ���д��ڼ�ֵ��
                return {m[target-nums[i]], i};		//�����±�(��ΪiΪ�ϴ��Ԫ�أ���ʱ��ӽ�ȥ�ļ�ֵ����С��i������i�ں���)
            m[nums[i]] = i; //���ϣ�������Ԫ��
        }
        return{};
    }   
};