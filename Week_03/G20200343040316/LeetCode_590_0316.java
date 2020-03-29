package com.wxs.algorithm1.week03;

import java.util.LinkedList;
import java.util.List;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-03-28
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class LeetCode_590_0316 {




    /**
     *  后续遍历N叉树， 时间复杂度是O(M) ,其中M 是N叉树的节点个数，每个节点只会入栈和出栈
     *  空间O(M) 需要把所有节点放入栈中 共有M -1 个节点
     * @param root
     * @return
     */
    public List<Integer> postorder(Node root) {

        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();


        stack.push(root);

        while (!stack.isEmpty()) {

            Node node = stack.pollLast();
            list.addFirst(node.val);

            for (Node child : node.children) {

                if (child != null) {
                    stack.add(child);
                }
            }


        }
        return list;

    }


}
