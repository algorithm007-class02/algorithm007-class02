import java.util.HashMap;

class Solution {
  public String minWindow(String s, String t) {
    int start = 0;
    int end = 0;
    int minLen = Integer.MAX_VALUE;
    int left = 0;
    int right = 0;
    int count = 0;

    HashMap<Character, Integer> needs = new HashMap<>();
    HashMap<Character, Integer> window = new HashMap<>();

    for (int i = 0; i < t.length(); i++) {
      //needs.getOrDefault(t.charAt(i),0)+1 含义是：needs如果包含t.charAt(i)，
      //则取出值+1;不包含取0+1
      needs.put(t.charAt(i), needs.getOrDefault(t.charAt(i), 0) + 1);
    }

    while (right < s.length()) {
      //获取字符
      char temp = s.charAt(right);
      //如果是t中字符，在window里添加，累计出现次数
      if (needs.containsKey(temp)) {
        window.put(temp, window.getOrDefault(temp, 0) + 1);
        //注意：Integer不能用==比较，要用compareTo
        if (window.get(temp).compareTo(needs.get(temp)) == 0) {
          //字符temp出现次数符合要求，count代表符合要求的字符个数
          count++;
        }
      }
      //优化到不满足到情况，right继续前进找可行解
      right++;
      //符合要求到字符个数正好是t中所有字符，获得一个可行解
      while (count == needs.size()) {
        //更新结果
        if (right - left < minLen) {
          start = left;
          end = right;
          minLen = end - left;
        }
        //开始进行优化，即缩小区间，删除s[left],
        char c = s.charAt(left);

        //当前删除到字符包含于t,更新window中对应出现的次数，如果更新后的次数<t中出现的次数，符合要求的字符数减1，下次判断count==needs.size()时不满足情况
        if(needs.containsKey(c)){
          window.put(c,window.getOrDefault(c,1)-1);
          if(window.get(c)<needs.get(c)){
            count--;
          }
        }
        left ++;
      }
    }
    //返回覆盖的最小串
    return minLen == Integer.MIN_VALUE ? "":s.substring(start,end);
  }
}