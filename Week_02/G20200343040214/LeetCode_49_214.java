import java.util.*;

public class Solution49 {
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        if (strs == null || strs.length <= 0)
            return list;
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] strChars = str.toCharArray();
            Arrays.sort(strChars);
            String newStr = String.valueOf(strChars);
            if (map.get(newStr) != null) {
                List<String> strList = map.get(newStr);
                strList.add(str);
            } else {
                List<String> strList = new ArrayList<>();
                strList.add(str);
                map.put(newStr, strList);
                list.add(strList);
            }
        }
        return list;
    }
}
