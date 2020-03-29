class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // sort str
        //return sortStr(strs);
        // count str
        return countStr(strs);
    }

    public List<List<String>> sortStr(String[] strs) {
        if(strs.length ==0) return new ArrayList();
        Map<String,List> ans = new HashMap<String,List>();
        for(String s : strs) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String key = String.valueOf(ch);
            if(!ans.containsKey(key)) {
                ans.put(key,new ArrayList());
            } 
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }

    public List<List<String>> countStr(String[] strs) {
        if(strs.length ==0) return new ArrayList();
        Map<String,List> ans = new HashMap<String,List>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for(char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if(!ans.containsKey(key)) {
                ans.put(key, new ArrayList());
            }
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
}