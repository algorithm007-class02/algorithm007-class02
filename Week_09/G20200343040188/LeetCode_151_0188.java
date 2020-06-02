package com.leetcode.string;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 151. 翻转字符串里的单词 给定一个字符串，逐个翻转字符串中的每个单词。
 * 示例 1：
 * 输入: "the sky is blue" 输出: "blue is sky the" 
 * 
 * 示例 2：
 * 输入: " hello world! " 输出: "world! hello" 解释:
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。 示例 3：
 * 
 * 输入: "a good example" 输出: "example good a" 解释:
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * 
 * 
 * 说明：
 * 
 * 无空格字符构成一个单词。 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * 
 * 
 * 进阶：
 * 
 * 请选用 C 语言的用户尝试使用 O(1) 额外空间复杂度的原地解法。
 */
public class L151ReverseWord {

    int spaceCount;

    /**
     * 使用语言特性解答
     * @param s
     * @return
     */
    public String reverseWords1(final String s) {
        final List<String> words = Arrays.asList(s.trim().split("\\s+"));
        Collections.reverse(words);
        return String.join(" ", words);
    }

    public String reverseWords(final String s) {
        assert s != null;

        final StringBuilder builder = removeSpaces(s);
        if (builder.length() == 0 || spaceCount == 0) {
            return "";
        }

        reverseString(builder, 0, builder.length() - 1);

        int begin = 0;
        for (int i = 0; i < builder.length(); i++) {
            if (builder.charAt(i) == ' ') {
                reverseString(builder, begin, i - 1);
                begin = i + 1;
            }
        }
        if (begin < builder.length() - 1) {
            reverseString(builder, begin, builder.length() - 1);
        }

        return builder.toString();
    }

    /**
     * 对输入进行预处理, trim, 去掉重复空格
     * 
     * @param s
     * @return
     */
    public StringBuilder removeSpaces(final String s) {
        final StringBuilder builder = new StringBuilder();

        char current = ' ';
        char prev = ' ';
        for (int i = 0; i < s.length(); i++) {
            current = s.charAt(i);
            if (current == ' ' && prev == ' ') {
                continue;
            }

            builder.append(current);
            prev = current;
            if (current == ' ') {
                spaceCount++;
            }
        }

        if (builder.length() == 0) {
            return builder;
        }

        if (builder.charAt(builder.length() - 1) == ' ') {
            builder.deleteCharAt(builder.length() - 1);
        }
        return builder;
    }

    void reverseString(final StringBuilder builder, int begin, int end) {
        while (begin < end) {
            final char tmp = builder.charAt(begin);
            builder.setCharAt(begin++, builder.charAt(end));
            builder.setCharAt(end--, tmp);
        }
    }

    public static void main(final String[] args) {
        final L151ReverseWord test = new L151ReverseWord();

        final StringBuilder builder = new StringBuilder();
        builder.append("foobar");
        test.reverseString(builder, 0, builder.length() - 1);
        assertThat(builder.toString()).isEqualTo("raboof");

        assertThat(test.reverseWords(" ")).isEqualTo("");
        assertThat(test.removeSpaces("  hello,  not   smoke!    ").toString()).isEqualTo("hello, not smoke!");
        assertThat(test.removeSpaces("").toString()).isEqualTo("");
        assertThat(test.removeSpaces(" ").toString()).isEqualTo("");
        assertThat(test.removeSpaces("  ").toString()).isEqualTo("");
        assertThat(test.removeSpaces("   ").toString()).isEqualTo("");
        assertThat(test.removeSpaces(" xx ssx ").toString()).isEqualTo("xx ssx");

        assertThat(test.reverseWords("")).isEqualTo("");
        assertThat(test.reverseWords(" ")).isEqualTo("");
        assertThat(test.reverseWords("a")).isEqualTo("a");
        assertThat(test.reverseWords("ab")).isEqualTo("ab");
        assertThat(test.reverseWords("foobar")).isEqualTo("foobar");
        assertThat(test.reverseWords("the sky is blue")).isEqualTo("blue is sky the");
        assertThat(test.reverseWords(" hello world! ")).isEqualTo("world! hello");
        assertThat(test.reverseWords("a good example")).isEqualTo("example good a");

        System.out.println("test done!");
    }

}