class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs==null || strs.length==0){
            return null;
        }
        Map<String,List<String>> resultMap = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] strChars = str.toCharArray();
            Arrays.sort(strChars);
            String key = String.valueOf(strChars);
            if (resultMap.containsKey(key)){
                resultMap.get(key).add(str);
            } else {
                List<String> value = new ArrayList<>();
                value.add(str);
                resultMap.put(key,value);
            }
        }
        return new ArrayList<>(resultMap.values());
    }
}