import java.util.HashMap;

class Solution {
    //利用数组进行两次遍历
    public int firstUniqChar1(String s) {
        int[] arr = new int[26];
        for(char c : s.toCharArray()){
            arr[c - 'a']++;
        }
        for(int i = 0;i < s.length();i++){
            if(arr[s.charAt(i)-'a'] == 1){
                return i;
            }
        }
        return -1;
    }

    //利用hashMap寻找第一个值为1的键的下标
    public int firstUniqChar2(String s) {
        HashMap<Character,Integer> count = new HashMap<Character,Integer>();
        int n = s.length();
        for(int i = 0;i < n;i++){
            char c = s.charAt(i);
            count.put(c,count.getOrDefault(c,0) + 1);
        }
        for(int i= 0;i < n;i++){
            if(count.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }
}