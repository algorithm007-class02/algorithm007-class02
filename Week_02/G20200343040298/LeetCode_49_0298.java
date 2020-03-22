import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//49.字母异位词分组
//将每个字符按照字母的顺序进行排序
//时间复杂度:最外面for O(n),排序O(klogk)所以为 O(nklogk)
class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] s = strs[i].toCharArray();
            //1 排序
            Arrays.sort(s);
            //2 映射到 key
            String key = String.valueOf(s);
            //3 添加到对应的分类中
            if (hashMap.containsKey(key)) {
                hashMap.get(key).add(strs[i]);
            } else {
                List<String> temp = new ArrayList<String>();
                temp.add(strs[i]);
                hashMap.put(key, temp);
            }

        }
        return new ArrayList<List<String>>(hashMap.values());

    }
}