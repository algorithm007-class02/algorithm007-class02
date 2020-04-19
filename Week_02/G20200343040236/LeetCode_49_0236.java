import java.util.List;
import java.util.Arrays;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

class LeetCode_189_0236 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0) return new ArrayList();
        Map<String,List<String>> map = new HashMap();
        for(int i = 0 ;i< strs.length;i++){
          char[] ch = strs[i].toCharArray();
            Arrays.sort(ch);
            String key = String.valueOf(ch);
            if (!map.containsKey(key)) map.put(key, new ArrayList());
            map.get(key).add(strs[i]);
        }

        return new ArrayList(map.values());
    }
}