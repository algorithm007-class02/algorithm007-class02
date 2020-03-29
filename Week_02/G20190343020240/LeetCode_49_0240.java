class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //1.对每个单词转换成字符数组后进行排序
        //2.将排序后的字符串添加到map中，排序后的字符串作为键，排序之前的字符串作为值，添加到List中
        //3.输出map的values集合（即为分组后的集合）
        Map<String,List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String newStr = new String(chars);
            if (!map.containsKey(newStr)) {
                List<String> arr = new ArrayList<>();
                arr.add(str);
                map.put(newStr,arr);
            } else {
                List<String> arr = map.get(newStr);
                arr.add(str);
                map.put(newStr,arr);
            }
        }
        return new ArrayList<>(map.values());
    }
}