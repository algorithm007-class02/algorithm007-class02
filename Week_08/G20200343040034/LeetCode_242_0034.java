package com.alang.learn.week8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * <p>
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_242_0034 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isAnagram("anagram", "nagaram"));
        System.out.println(solution.isAnagram1("anagram", "nagaram"));
        System.out.println(solution.isAnagram2("anagram", "nagaram"));
        System.out.println(solution.isAnagram("rat", "car"));
        System.out.println(solution.isAnagram1("rat", "car"));
        System.out.println(solution.isAnagram2("rat", "car"));
        int[] arr = {3, 38, 5, 44, 15, 26};
        solution.bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static public class Solution {
        public boolean isAnagram(String s, String t) {
            if (s == null && t == null) return true;
            if (s == null || t == null || s.length() != t.length()) return false;
            int[] counts = new int[26];
            int length = s.length();
            for (int i = 0; i < length; i++) {
                counts[s.charAt(i) - 'a']++;
            }
            for (int i = 0; i < length; i++) {
                counts[t.charAt(i) - 'a']--;
                if (counts[t.charAt(i) - 'a'] < 0) return false;
            }
            return true;
        }

        public boolean isAnagram1(String s, String t) {
            if (s == null && t == null) return true;
            if (s == null || t == null || s.length() != t.length()) return false;
            int[] counts = new int[26];
            for (int i = 0, l = s.length(); i < l; i++) {
                counts[s.charAt(i) - 'a']++;
                counts[t.charAt(i) - 'a']--;
            }
            for (int i = 0; i < 26; i++) {
                if (counts[i] != 0) return false;
            }
            return true;
        }

        public boolean isAnagram2(String s, String t) {
            if (s == null && t == null) return true;
            if (s == null || t == null || s.length() != t.length()) return false;
            HashMap<Character, Integer> memo = new HashMap<Character, Integer>();
            char c1, c2;
            for (int i = 0, l = s.length(); i < l; i++) {
                c1 = s.charAt(i);
                c2 = t.charAt(i);
                memo.put(c1, memo.getOrDefault(c1, 0) + 1);
                memo.put(c2, memo.getOrDefault(c2, 0) - 1);
            }
            for (Character c : memo.keySet()) {
                if (memo.get(c) != 0) return false;
            }
            return true;
        }

        public void selectionSort(int[] arr) {
            int minIndex;
            for (int i = 0; i < arr.length - 1; i++) {
                minIndex = i;
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] < arr[minIndex]) minIndex = j;
                }
                swap(arr, i, minIndex);
            }

        }

        public void insertSort(int[] arr) {
            for (int i = 1; i < arr.length; i++) {
                for (int j = i; j > 0; j--) {
                    if (arr[j] < arr[j - 1]) {
                        swap(arr, j, j - 1);
                    } else {
                        break;
                    }
                }
            }
        }

        public void bubbleSort(int[] arr) {
            boolean swaped;
            for (int i = 0; i < arr.length - 1; i++) {
                swaped = false;
                for (int j = 0; j < arr.length - 1 - i; j++) {
                    if (arr[j] > arr[j + 1]) {
                        swap(arr, j, j + 1);
                        swaped = true;
                    }
                }
                if (!swaped) return;
            }
        }

        private void swap(int[] arr, int i, int j) {
            arr[i] = arr[i] ^ arr[j] ^ (arr[j] = arr[i]);
        }
    }
}
