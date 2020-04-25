//����һ
class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        vector<vector<string>> res;
        unordered_map<string, int> work;//�ж�����󵥴��Ƿ���ڣ�����ĸ����Ƿ�һ�£����浥�ʶ�Ӧ��vector�±�
        string tmp; //��ʱstring
        int sub = 0; //���vector���±�ֵ

        for (auto str : strs) {
            tmp = str;
            sort(tmp.begin(), tmp.end());
            if (work.count(tmp)) {
                res[work[tmp]].push_back(str);
            }
            else {
                vector<string> vec(1, str);
                res.push_back(vec);
                work[tmp] = sub++;
            }
        }
        return res;
    }
};

//����������ȷ���һ��һ��ѭ��
class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, vector<string>> mp;//��������󵥴ʶ�Ӧ�ĵ����б�
        string tmp;//��ʱstring

        for (auto str : strs) {
            tmp = str;
            sort(tmp.begin(), tmp.end());
            mp[tmp].push_back(str);
        }

        vector<vector<string>> res;
        for (auto p : mp) {
            res.push_back(p.second);
        }
        return res;
    }
};