package com.logic;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Auther: welllu
 * @Date: 2020/4/26 21:36
 * @Description:
 */
public class LeeCode_433_0226 {
    //BFS
    // queue init and visited init
    // process node and related
    // other process work
    public int minMutation(String start, String end, String[] bank) {

        if(start.equals(end)) {
            return 0;
        }

        HashSet<String> hs = new HashSet<> ();
        for(String b: bank) {
            hs.add(b);
        }

        HashSet<String> visiteds = new HashSet<>();
        Queue<String> queue = new LinkedList<> ();

        visiteds.add(start);
        queue.add(start);

        int level = 0;

        char[] munate = new char[]{'A','C','G','T'};
        while(!queue.isEmpty()) {
            for (int k = queue.size(); k > 0; k --) {
                String cur = queue.poll();
                if(cur.equals(end)) return level;
                char[] arr = cur.toCharArray();
                for(int i = 0;i < arr.length; i ++) {
                    char old = arr[i];
                    for(int j = 0; j < munate.length; j ++) {
                        arr[i] = munate[j];
                        String next = String.valueOf(arr);
                        if(!visiteds.contains(next) && hs.contains(next)) {
                            queue.add(next);
                            visiteds.add(next);
                        }
                    }
                    //恢复
                    arr[i] = old;
                }
            }
            level ++;
        }

        return -1;

    }
}
