/**
 * // Definition for a Node.
 * function Node(val, children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */
/**
 * @param {Node} root
 * @return {number[]}
 */
 // N叉树的前序遍历
var preorder = function(root) {
    if(!root) {
        return []
    }
    if(!root.children.length) {
        return [root.val]
    }
    var result = []
    result.push(root.val)
    for(var i = 0; i < root.children.length; i++) {
        var subresult = preorder(root.children[i])
        result = result.concat(subresult)
    }
    
    return result
};