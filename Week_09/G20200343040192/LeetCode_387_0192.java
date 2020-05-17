class Solution {
  public int firstUniqChar(String s) {

    // 分成两种情况：
    // 第一种为字符串长度小于26的，遍历字符串
    if (s.length() <= 26) {
      int[] charNum = new int[26];//存储各字符出现次数
      char[] chars = s.toCharArray();
      int length = chars.length;
      for (int i = 0; i < length; i++) {//第一次遍历,记录各个字符出现次数
        charNum[chars[i] - 'a']++;
      }
      for (int i = 0; i < length; i++) {//第二次遍历，按顺序，如果次数为1，返回下标
        if (charNum[chars[i] - 'a'] == 1) {
          return i;
        }
      }
      return -1;//无解
    }

    // 第二种字符串长度大于26，遍历26个字母
    // 反过来，只有26个字符
    int index = -1;
    for (char ch = 'a'; ch <= 'z'; ch++) {
      int beginIndex = s.indexOf(ch);
      // 从头开始的位置是否等于结束位置，相等说明只有一个，
      if (beginIndex != -1 && beginIndex == s.lastIndexOf(ch)) {
        //取小的，越小代表越前。
        index = (index == -1 || index > beginIndex) ? beginIndex : index;
      }
    }
    return index;
  }
}
