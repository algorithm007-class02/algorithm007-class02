class Solution {
    //使用代表法啦 使用HashMap;
    //先对拿出来的字符串变成字符数组；然后进行排序！
    //然后存进HashMap;因为排序后字符相同的都相等了那么就可以保证，字符相同的在一个List了！
    //然后取出来再返回
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<String , List<String>>();
        for(String temp : strs){
            char[] arrayChar = temp.toCharArray();
            Arrays.sort(arrayChar);
            String changeStr =  String.valueOf(arrayChar);
            if(!map.containsKey(changeStr)){
                map.put(changeStr ,  new ArrayList<String>());
            }
            map.get(changeStr).add(temp);
        }
        List<List<String>> lists = new ArrayList<List<String>>(map.values());
         return lists;
    }
}