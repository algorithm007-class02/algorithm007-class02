#include<vector>
#include<map>
using namespace  std;
class Solution {
public:
    unordered_map<int,int> posAtInorder;
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        for(int i=0;i<inorder.size();i++){
            posAtInorder[inorder[i]] = i;
        }
        return helper(preorder,0,preorder.size()-1,inorder,0,inorder.size()-1);
    }
    TreeNode* helper(vector<int>& preorder,int pl,int pr,
                    vector<int>& inorder,int il,int ir){
        // 3 [9] [20,15,7]
        // [9] 3 [15,20,7]
        // terminator
        if(pl>pr){
            return NULL;
        }
        TreeNode* temp = new TreeNode(preorder[pl]);
        int mid = posAtInorder[preorder[pl]];
        temp->left = helper(preorder,pl+1,pl+(mid-il),inorder,il,mid-1);
        temp->right = helper(preorder,pl+(mid-il)+1,pr,inorder,mid+1,ir);
        return temp;
    }

};