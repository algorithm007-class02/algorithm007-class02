class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map=new HashMap<Character, Integer>();
        for(char i : s.toCharArray()){
            if(map.containsKey(i)){
                int count = map.get(i);
                count+=1;
                map.put(i,count);
            }else{
                map.put(i,1);
            }

        }
        for(char i : t.toCharArray()){
            if(map.containsKey(i)){
                int count = map.get(i);
                count-=1;
                if(count == 0){
                    map.remove(i);
                }else{
                    map.put(i,count);
                }
            }else{
                return false;
            }
        }
        return map.isEmpty();
    }
}
//第一个串存入map，对比第二个字符串，最后如果map为空则相同