/*给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

示例:

输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
说明：

所有输入均为小写字母。
不考虑答案输出的顺序。
*/


class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //哈希表存  key 排序好的字符串 ，value List str
        if(strs == null || strs.length <= 0){
            return new ArrayList<>();
        }

        Map<String,List> strListMap = new HashMap<String,List>();
        for(int i = 0 ;i < strs.length;i++){
            String str = strs[i];
            //字母排序
            char[] strCharArr = str.toCharArray();
            Arrays.sort(strCharArr);
            String orderStr = String.valueOf(strCharArr);
            //不存在则新创建 str List
            if(!strListMap.containsKey(orderStr)){
                strListMap.put(orderStr,new ArrayList<String>());
            }
            strListMap.get(orderStr).add(str);
        }
        return new ArrayList(strListMap.values());
    }
}

//复杂度分析

//时间复杂度：O(NKlogK)，其中 N 是 strs 的长度，而 K 是 strs 中字符串的最大长度。当我们遍历每个字符串时，外部循环具有的复杂度为 O(N)。然后，我们在O(KlogK) 的时间内对每个字符串排序。

//空间复杂度：O(NK)，排序存储在 strListMap 中的全部信息内容。
