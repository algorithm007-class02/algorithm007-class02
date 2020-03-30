package com.wxs.algorithm1.week03;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-03-28
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class LeetCode_429_0316 {

    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> all = new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {

            List<Integer> list = new ArrayList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {

                Node remove = queue.remove();
                list.add(remove.val);
                queue.addAll(remove.children);
            }

        }

        return all;

    }


}
