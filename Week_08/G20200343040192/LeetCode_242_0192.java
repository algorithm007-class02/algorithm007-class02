class Solution {

  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    Map<Character, Integer> charMap1 = new HashMap<>((int) (s.length() / 0.75F + 1.0F));
    Map<Character, Integer> charMap2 = new HashMap<>((int) (s.length() / 0.75F + 1.0F));
    for (char c : s.toCharArray()) {
      charMap1.put(c, charMap1.getOrDefault(c, 0) + 1);
    }
    for (char c : t.toCharArray()) {
      charMap2.put(c, charMap2.getOrDefault(c, 0) + 1);
    }
    if (charMap1.size() != charMap2.size()) {
      return false;
    }
    for (char c : s.toCharArray()) {
      if (!charMap1.get(c).equals(charMap2.getOrDefault(c, 0))) {
        return false;
      }
    }
    return true;
  }
}

