// 字母异位词分组  https://leetcode-cn.com/problems/group-anagrams/
public List<List<String>>groupAnagrams(String[]strs){
        if(null==strs||strs.length==0)return new ArrayList<List<String>>();

        Map<String, List<String>>groupedMap=new HashMap<>();
        for(String words:strs){
        char[]arr=words.toCharArray();
        Arrays.sort(arr);
        String key=Arrays.toString(arr);
        if(groupedMap.containsKey(key)){
        groupedMap.get(key).add(words);
        }else{
        List<String> newList=new ArrayList<String>();
        newList.add(words);
        groupedMap.put(key,newList);
        }

        }
        return new ArrayList<List<String>>(groupedMap.values());
        }
