class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List> ans = new HashMap<String, List>();
        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String key = String.valueOf(charArray);
            if (!ans.containsKey(key)){
                ans.put(key, new ArrayList());
            } 
            ans.get(key).add(s);

        }



        return new ArrayList(ans.values());

    }
}