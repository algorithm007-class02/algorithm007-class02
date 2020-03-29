class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 1.可以使用先将字符串自身排序然后在放在hash表的键上，hash表中value则维护排好序后跟键一样的字符串
        // 2.将字符串中每个字母转换为数组的下标之后再计算数量，之后将这个数据转换为字符串形式在存到hash表中

        Map<String, List<String>> map = new HashMap<>();
        int[] temp;
        StringBuilder sb;
        for (int i = 0; i < strs.length; i ++) {
            String item = strs[i];
            temp = new int[26];
            for(int j = 0; j < item.length(); j++) {
                temp[item.charAt(j) - 'a'] += 1;
            }

            sb = new StringBuilder();
            for (int k = 0; k < temp.length; k++) {
                sb.append("#");
                sb.append(String.valueOf(temp[k]));
            }

            String covertStr = sb.toString();
            List<String> list = map.get(covertStr);
            if(list == null) {
                list = new ArrayList<>();
                map.put(covertStr, list);
            } 
            list.add(item);
            
        }
        return new ArrayList<List<String>>(map.values());
    }
}