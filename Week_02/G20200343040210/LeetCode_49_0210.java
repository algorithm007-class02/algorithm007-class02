/** 49 ��ĸ��λ�ʷ���
*����һ���ַ������飬����ĸ��λ�������һ����ĸ��λ��ָ��ĸ��ͬ�������в�ͬ���ַ�����

ʾ��:

����: ["eat", "tea", "tan", "ate", "nat", "bat"],
���:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
˵����

���������ΪСд��ĸ��
�����Ǵ������˳��

��Դ�����ۣ�LeetCode��
���ӣ�https://leetcode-cn.com/problems/group-anagrams
����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
*/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<String> list = null;
        for (String str : strs) {            
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String newStr = new String(c);
            if (map.containsKey(newStr)) {
                list = map.get(newStr);
                list.add(str);
                map.put(newStr,list);
            } else {
                list = new ArrayList<String>();
                list.add(str);
                map.put(newStr,list);
            }
        }
        return new ArrayList<>(map.values());
    }
}