/**
 * // Definition for a Node.
 * function Node(val,children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */
/**
 * @param {Node} root
 * @return {number[]}
 */
// N叉树的后序遍历
var postorder = function(root) {
    if(!root) {
        return []
    }
    if(!root.children.length) {
        return [root.val]
    }
    var result = []
    for(var i = 0; i < root.children.length; i++) {
        var subresult = postorder(root.children[i])
        result = result.concat(subresult)
    }
    result.push(root.val)
    return result
};