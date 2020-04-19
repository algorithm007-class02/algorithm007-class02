/**
 *  144. 二叉树的前序遍历
 * */


/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */


/**
 * Note: The returned array must be malloced, assume caller calls free().
 */

//迭代法
int* preorderTraversal(struct TreeNode* root, int* returnSize){
    *returnSize = 0;
    if(!root)
        return NULL;

    int *leftRes=NULL,*rightRes=NULL,leftSize=0,rightSize=0;
    leftRes=preorderTraversal(root->left,&leftSize);
    rightRes=preorderTraversal(root->right,&rightSize);
    
    int *res = malloc(sizeof(int)*(1+leftSize+rightSize));
    
    res[(*returnSize)++] = root->val;
    for(int i=0;i<leftSize;++i) {
        res[(*returnSize)++] = leftRes[i];
    }
    for(int i=0;i<rightSize;++i) {
        res[(*returnSize)++] = rightRes[i];
    }
    if(leftRes)
        free(leftRes);
    if(rightRes)
        free(rightRes);

    return res;
}

