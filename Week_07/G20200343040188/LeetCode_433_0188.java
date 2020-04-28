package com.leetcode.search;

import java.util.*;

/**
 * 433. 最小基因变化
 * 一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。
 *
 * 假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。
 *
 * 例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了一次基因变化。
 *
 * 与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。
 *
 * 现在给定3个参数 — start, end, bank，分别代表起始基因序列，目标基因序列及基因库，请找出能够使起始基因序列变化为目标基因序列所需的最少变化次数。如果无法实现目标变化，请返回 -1。
 *
 * 注意:
 *
 * 起始基因序列默认是合法的，但是它并不一定会出现在基因库中。
 * 所有的目标基因序列必须是合法的。
 * 假定起始基因序列与目标基因序列是不一样的。
 */
public class L433MinGen {

    Queue<String> queue = new LinkedList<>();
    char[] genChars = new char[] {'A', 'C', 'G', 'T'};
    Set<String> bankSet = new HashSet<>();

    public int minMutation(String start, String end, String[] bank) {
        if(bank == null || bank.length == 0 ||
                start == null || end == null) {
            return -1;
        }

        System.out.println("end: " + end);
        int step = 0;
        Arrays.stream(bank).forEach(s -> bankSet.add(s));

        // 数据建模：思路是穷举出所有基因，图的节点是基因序列，图的边是基因库的成员
        // 典型的bfs模板
        queue.add(start);
        while (!queue.isEmpty()) {
            step++;
            System.out.println("step: " + step);

            int queueSize = queue.size();
            for (int levelCount = 0; levelCount < queueSize; levelCount++) {
                String current = queue.poll();
                for (int pos = 0; pos < start.length(); pos++) {
                    // 将current的第一个 变成 "A", "C", "G", "T"
                    char[] chars = current.toCharArray();
                    char oldChar = chars[pos];
                    for (int i = 0; i < genChars.length; i++) {
                        if (oldChar == genChars[i]) {
                            continue;
                        }
                        chars[pos] = genChars[i];
                        String tmp = new String(chars);

                        if (!bankSet.contains(tmp)) {
                            continue;
                        }

                        if (end.equals(tmp)) {
                            System.out.println(end + ", end!");
                            System.out.println(tmp + ", found!");
                            return step;
                        } else {
                            System.out.println(tmp + ", queued!");
                            queue.add(tmp);
                            bankSet.remove(tmp);
                        }
                    }
                    chars[pos] = oldChar;
                }
            }
        }
        return -1;
    }


}
