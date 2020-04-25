/**
 * 589. N叉树的前序遍历
 * 
 * */

//递归

/**
 * Definition for a Node.
 * struct Node {
 *     int val;
 *     int numChildren;
 *     struct Node** children;
 * };
 */

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* preorder(struct Node* root, int* returnSize) {
    if(!root) {
        *returnSize = 0;
        return NULL;
    }
    
    int lastSize=0;
    int *lastRes = malloc(sizeof(int));
    lastRes[lastSize++] = root->val;

    for(int i=0;i<root->numChildren;++i) {
        int *thisRes=0, thisSize=0;
        thisRes = preorder(root->children[i],&thisSize);
        if(thisRes) {
            int *newRes = malloc(sizeof(int)*(thisSize+lastSize));
            for(int i=0;i<lastSize;++i) {
                newRes[i] = lastRes[i];
            }
            for(int i=0;i<thisSize;++i,++lastSize) {
                newRes[lastSize] = thisRes[i];
            }
            if(lastRes)
                free(lastRes);
            lastRes = newRes;
        }
    }

    *returnSize = lastSize;
    return lastRes;
}


















