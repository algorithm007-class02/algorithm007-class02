/*
49. 字母异位词分组
给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

示例:
输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
*/

class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) 
{
    vector<vector<string>> tmpVecReturn;
    if (0 == strs.size())
    {
        return tmpVecReturn;
    }
 
    string tmpStr;
    map<string, int> tmpHashCount;
    int n = 0;
    for (int i = 0; i < strs.size(); i++)
    {
        /*计算单个值*/
        int tmpArray[26] = { 0 };
        for (int j = 0; j < strs[i].size(); j++)
        {
            ++tmpArray[strs[i][j]-'a'];/*经过转换后的字母次数*/
        }
 
        char strCount[27] = {0};
        for (int k = 0; k < 26; k++)
        {
            snprintf(strCount +strlen(strCount), sizeof(strCount)-strlen(strCount), "%d", tmpArray[k]);
        }

        /*异位词赋值*/
        vector<string> tmpVec;
        if (tmpHashCount.end() == tmpHashCount.find(strCount))
        {
            /*哈希表里找不到，直接添加进去*/
            tmpVec.push_back(strs[i]);
            tmpVecReturn.push_back(tmpVec);

            tmpHashCount[strCount] = n;/*将字母次数插入临时hash table， 保存的value值可以用于下面else的查找*/
            n++;
        }
        else
        {
            /*哈希表里找到了，需要找到存放的vector,然后添加到同一组里*/
            //map<string, int>::iterator mitTmp = tmpHashCount.find(strCount);
            tmpVecReturn[tmpHashCount.find(strCount)->second].push_back(strs[i]);
        }
    }

    return tmpVecReturn;
 }
};