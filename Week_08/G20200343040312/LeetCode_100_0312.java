//给定两个二叉树，编写一个函数来检验它们是否相同。 
//
// 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。 
//
// 示例 1: 
//
// 输入:       1         1
//          / \       / \
//         2   3     2   3
//
//        [1,2,3],   [1,2,3]
//
//输出: true 
//
// 示例 2: 
//
// 输入:      1          1
//          /           \
//         2             2
//
//        [1,2],     [1,null,2]
//
//输出: false
// 
//
// 示例 3: 
//
// 输入:       1         1
//          / \       / \
//         2   1     1   2
//
//        [1,2,1],   [1,1,2]
//
//输出: false
// 
// Related Topics 树 深度优先搜索

/*
我们如何判断两树（l、r）相等呢？

        根节点值相等
        l的左子树和r的左子树相等
        l的右子树和r的右子树相等
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null && q==null) {return true;}  //递归到最后时节点都为空，则是相同的树
        if (p==null || q==null) {return false;}  //递归到最后，节点一个有一个没有，肯定不相同
        if (p.val!=q.val) {return false;}  //如果都有，则当值相等时返回“相同”
        return isSameTree(p.left, q.left) && isSameTree(p.right,q.right);
    }
    /*
     * 耗时0ms（100%），使用内存36.8M（6%）*/
}
//leetcode submit region end(Prohibit modification and deletion)
