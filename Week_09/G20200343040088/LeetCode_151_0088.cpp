class Solution {
public:
    string reverseWords(string s) {
        if (s.empty()) return "";

        vector<string> vec;
        string temp;
        for (auto str : s) {
            if ( str == ' ') {
                if (temp.size()) {
                    vec.push_back(temp);
                }
                temp = "";
            } else {
                temp = temp + str;
            }
        }

        if(temp.size()) vec.push_back(temp);

        string ret;
        for (int j = vec.size() - 1; j > 0; j--){
            ret = ret + vec[j] + ' '; 
        }

        if (vec.size()) ret = ret + vec[0];
        return ret;
    }
};
