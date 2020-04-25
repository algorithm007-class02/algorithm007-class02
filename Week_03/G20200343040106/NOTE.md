# 树

## binary-tree traversal without recursion
这种题目，我个人选择了几个笔记适合自己口味的模板背诵了下来。
### Ⅰ，preoderTraversal-without recursion
```

void preorderTraversal(TreeNode* root) {
        TreeNode* p = root;
        vector<int> ans;
        stack<TreeNode*> s;
        while(p||!s.empty()){
            while(p){
            	visit(p);//先序遍历，在入栈前访问
                s.push(p);
                p = p->left;
            }
            if(!s.empty()){
                p = s.top();
                s.pop();
                p = p->right;
            }
        }
        return;
    }
```
### Ⅱ，inorderTraversal-without recursion
注意，与先序遍历几乎一模一样，唯一不同的是我们需要在出栈时访问结点。
```
void inorderTraversal(TreeNode* root) {
        TreeNode* p = root;
        vector<int> ans;
        stack<TreeNode*> s;
        while(p||!s.empty()){
            while(p){
                s.push(p);
                p = p->left;
            }
            if(!s.empty()){
                p = s.top();
                s.pop();
                visit(p);    //中序遍历，在出栈时访问。
                p = p->right;
            }
        }
        return ;
    }
```
### Ⅲ，postorderTraversal-without recursion
后序遍历比较难实现。

我们维护一个lastvisited，这个结点的意义是，上次访问的结点。维护这个结点的意义是，**如果当前节点是上次访问节点的父节点，则说明子树访问完成，可以访问当前节点了。**

```
void postorderTraversal(TreeNode* root){
	if(!root)
		return ;
	stack<TreeNode*> s;
	s.push(root);
	TreeNode* lastVisited = root;
	while(!s.empty()){
		TreeNode* p = s.top();
		s.pop();
		//如果当前结点：
		//1，为叶子结点
		//2，当前结点的左孩子/右孩子已经访问过了。
		if((p->left==NULL&&p->right==NULL)||(p->left==lastVisited||p->right==lastVisited)){
			visit(p);
			lastVisited = p;
		}else{
			s.push(p);
			if(p->right) s.push(p->right);
			if(p->left)  s.push(p->left);
		}
	}
}
```

## LeetCode-590-N叉树的后序遍历

我们直接改造二叉树的后序遍历代码。

```
class Solution {
public:
    vector<int> postorder(Node* root) {
        vector<int> ans;
        if(!root)
            return ans;
        stack<Node*> s;
        Node* lastVisited = root;
        s.push(root);
        while(!s.empty()){
            Node* p = s.top();
            s.pop();
            //采用TOP-DOWN编程方法
            if(isChild(p)||ChildContain(p,lastVisited)){
                ans.push_back(p->val);
                lastVisited = p;
            }else{
                s.push(p);
                vector<Node*> temp = p->children;
                //把p的子节点，从右往左入栈
                for(int i = (int)temp.size()-1;i>=0;i--){
                    if(temp[i]){
                        s.push(temp[i]);
                    }
                }
            }
        }
        return ans;
    }

    bool isChild(Node* root){
        vector<Node*> temp = root->children;
        for(auto i:temp){
            if(i)
                return false;
        }
        return true;
    }
    bool ChildContain(Node* root,Node* target){
        vector<Node*> temp = root->children;
        for(auto i:temp){
            if(i==target)
                return true;
        }
        return false;
    }
};

```



## LeetCode-589-N叉树先序遍历

先序遍历是最容易的，不管是二叉树还是N叉树。

```
class Solution {
public:
    vector<int> preorder(Node* root) {
        vector<int> ans;
        if(!root)
            return ans;
        stack<Node*> s;
        s.push(root);
        while(!s.empty()){
            Node* p = s.top();
            s.pop();
            ans.push_back(p->val);
            vector<Node*> temp = p->children;
            for(int i=(int)temp.size()-1;i>=0;i--){
                if(temp[i])
                    s.push(temp[i]);
            }
        }
        return ans;
    }
};
```

## LeetCode-429-N叉树层序遍历

这一题由于要求返回vector<vector<int>>  类型的数据，所以不能直接套模板做。

我的直观想法是用双队列来做，两个对量push来push去。事实也是AC了。

```

class Solution {
public:
    vector<vector<int>> levelOrder(Node* root) {
        vector<vector<int>> ans;
        if(!root)
            return ans;
        
        queue<Node*> q[2];
        int robin = 0;         //代表循环，robin取值0或1，0表示q[0]队列。
        q[0].push(root);
        vector<int> temp;
        while(!q[robin].empty()){
            Node* t = q[robin].front();
            q[robin].pop();
            temp.push_back(t->val);
            vector<Node*> child = t->children;
            for(auto i:child){
                if(i) q[(robin+1)%2].push(i);
            }
            if(q[robin].empty()){
                ans.push_back(temp);
                temp.clear();
                robin = (robin+1)%2;
            }
        }
        return ans;
    }
};
```

但总觉得不够优雅，毕竟用到了两个队列，于是看了国际站高票解答，发现明明可以这么简答。

```
class Solution {
public:
    vector<vector<int>> levelOrder(Node* root) 
	{
        if (root == NULL) 
			return vector<vector<int>>();
        vector<vector<int>> res;
        queue<Node*> q;
        q.push(root); 
        while (!q.empty()) 
        {
            int size = q.size(); //这一步很关键。
            vector<int> curLevel; 
            for (int i = 0; i < size; i++) 
            {
                Node* tmp = q.front(); 
                q.pop(); 
                curLevel.push_back(tmp -> val); 
                for (auto n : tmp -> children) 
                     q.push(n); 
            }
            res.push_back(curLevel);
        }
        return res; 
    }
};
```

# 堆

## LeetCode-347-前k个高频元素

注意：这题不是TopK问题，而是统计前k个高频元素，所以我们需要用堆，没法用快排的partition



## LeetCode-264-丑数Ⅱ

### 思路Ⅰ：堆

维护一个小根堆，一个一个去找。

每一次都弹出最小值i，然后压入i×2，i×3，i×5。

### 思路Ⅱ：DP

DP还没学，摘抄大佬代码。

```

struct Solution {
    int nthUglyNumber(int n) {
        vector <int> results (1,1);
        int i = 0, j = 0, k = 0;
        while (results.size() < n)
        {
            results.push_back(min(results[i] * 2, min(results[j] * 3, results[k] * 5)));
            if (results.back() == results[i] * 2) ++i;
            if (results.back() == results[j] * 3) ++j;
            if (results.back() == results[k] * 5) ++k;
        }
        return results.back();
    }
};
```

不太懂这样为啥是DP？怎么想的呢？

# 递归

## LeetCode-226-反转二叉树

思路：对每个结点的左右孩子进行替换，可以递归，也可以非递归的DFS和BFS。因为我们需要访问每一个结点（遍历），然后对换它的左右孩子。

​	

## LeetCode-98-验证二叉搜索树

### 思路一：中序遍历

```
class Solution {
public:
    bool isValidBST(TreeNode* root) {
        TreeNode* p = root;
        TreeNode* prev = NULL;
        stack<TreeNode*> s;
        while(p||!s.empty()){
            while(p){
                s.push(p);
                p = p->left;
            }
            if(!s.empty()){
                p = s.top();
                s.pop();
                if(prev!=NULL&&p->val<=prev->val)
                    return false;
                prev = p;
                p = p->right;
            }
        }
        return true;
    }
};
```



### 思路二：递归

先给出一个错误的版本(我写的第一个版本，也是经典的错误版本)：

```
class Solution {

public:

    bool isValidBST(TreeNode* root) {

        return helper(root,INT_MIN,INT_MAX);

    }

    bool helper(TreeNode* root,int lower_bound,int up_bound){

        if(root==NULL)

            return true;

        if((root->val<=lower_bound||root->val>=up_bound))

            return false;

        return helper(root->left,lower_bound,root->val)&&

            helper(root->right,root->val,up_bound);

        

    }

};

```

上面这个代码看起来优雅良好，事实上，对于极端的case（带有INT_MIN,INT_MAX）的，很难解决。当然我们可以引入LONG_MIN和LONG_MAX，但我始终觉得不够优雅。引入大佬的代码；

```
class Solution {
public:
    bool isValidBST(TreeNode* root) {
        TreeNode* pre = NULL;
        return helper(root,pre);
    }
    bool helper(TreeNode* root,TreeNode* &pre){
        if(root==NULL)
            return true;
        if(!helper(root->left,pre))
            return false;
        if(pre!=NULL&&pre->val>=root->val)
            return false;
        pre = root;
        return helper(root->right,pre);
        
    }
};
```

