
class Solution {

  /**
   * 内存超限法 哈哈
   *
   * @param strs
   * @return
   */
  public List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> result = new ArrayList<>();
    for (int i = 0; i < strs.length; i++) {
      char[] str1 = strs[i].toCharArray();
      Arrays.sort(str1);
      List<String> unit = new ArrayList<>();
      unit.add(strs[i]);
      for (int j = i + 1; j < strs.length; i++) {
        char[] str2 = strs[j].toCharArray();
        Arrays.sort(str2);
        if (Arrays.equals(str1, str2)) {
          unit.add(strs[j]);
        }
      }
      result.add(unit);
    }
    return result;
  }

  /**
   * 暴力解 map
   * @param strs
   * @return
   */
  public List<List<String>> groupAnagrams1(String[] strs) {
    if (strs.length == 0) {
      return new ArrayList();
    }
    Map<String, List> ans = new HashMap<String, List>();
    for (String s : strs) {
      char[] ca = s.toCharArray();
      Arrays.sort(ca);
      String key = String.valueOf(ca);
      if (!ans.containsKey(key)) {
        ans.put(key, new ArrayList());
      }
      ans.get(key).add(s);
    }
    return new ArrayList(ans.values());
  }

}