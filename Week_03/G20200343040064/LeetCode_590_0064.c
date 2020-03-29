/**
 * 590. N叉树的后序遍历
 * */

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

//递归法

int* postorder(struct Node* root, int* returnSize) {
    
    if(!root) {
        *returnSize = 0;
        return NULL;
    }

    int lastNum = 0, *lastRes = NULL;
    for(int i=0;i<root->numChildren;++i) {
        int *thisRes = NULL,thisNum = 0;
        if(!root->children[i])
            continue;

        thisRes = postorder(root->children[i],&thisNum);
        if(thisRes) {
            int *newRes = malloc(sizeof(int) * (lastNum + thisNum));
            for(int i=0;i<lastNum;++i) {
                newRes[i] = lastRes[i];
            }
            for(int i=0;i<thisNum;++i) {
                newRes[lastNum++] = thisRes[i];
            }
            if(lastRes)
                free(lastRes);
            lastRes = newRes;
        }
    }

    int *newRes = malloc(sizeof(int)*(lastNum+1));
    for(int i=0;i<lastNum;++i) {
        newRes[i] = lastRes[i];
    }
    newRes[lastNum++] = root->val; 
    if(lastRes) {
        free(lastRes);
    }
    lastRes = newRes;

    *returnSize = lastNum;
    return lastRes;
}