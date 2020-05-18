package week09.g20200343040172;

public class LeetCode_387_0172 {
  /**
   * 使用数组统计单词中每个字符出现的次数
   */
  class Solution1 {
    public int firstUniqChar(String s) {
      int[] count = new int[26];
      for (char tmp : s.toCharArray()) {
        count[tmp - 'a'] += 1;
      }
      for (int i = 0; i < s.length(); ++i) {
        if (count[s.charAt(i) - 'a'] == 1) {
          return i;
        }
      }
      return -1;
    }
  }
}
