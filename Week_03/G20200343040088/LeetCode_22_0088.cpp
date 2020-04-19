class Solution {
public:
    vector<string> generateParenthesis(int n) {
        if (n <= 0) return vecRes;

        string str("");
        helper(n, 0, 0, str);
        return vecRes;
    }

    void helper(int max, int left, int right, string str) {
        // 1. terminator
        if (left == max && right == max) {
            vecRes.push_back(str);
            return;
        }
        // 2. process 

        if (left < max) {
            string str1 = str + '(';
            helper(max, left + 1, right, str1);
        }


        if (right < left) 
        {
            string str2 = str +  ')';
            helper(max, left, right + 1, str2);
        }

        // 3. drill down
        // 4 clear state
    }

private:
    vector<string> vecRes;
};