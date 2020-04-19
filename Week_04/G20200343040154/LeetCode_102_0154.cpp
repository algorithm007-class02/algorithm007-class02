// 102. 二叉树的层序遍历
// https://leetcode-cn.com/problems/binary-tree-level-order-traversal/

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

// 1. DFS解法 
// 递归法：pre/in/post order均可，只要左节点在右节点之前即可
// 时间：O(N) 空间：O(1)
// class Solution {
// public:
//     vector<vector<int>> levelOrder(TreeNode* root) {
//         vector<vector<int>> ans;
//         DFS(root, 0 /* depth */, ans);
//         return ans;
//     }
//     void DFS(TreeNode* node, int depth, vector<vector<int>>& ans) {  /* &ans 表示取到ans的内存地址 */
//         if (!node) return;
//         while(ans.size() <= depth) ans.push_back({});
//         ans[depth].push_back(node->val); // 前序遍历
//         DFS(node->left, depth+1, ans);
//         DFS(node->right, depth+1, ans);
//     }
// };

//  // 2. DFS解法
//  // 递归法：pre/in/post order均可，只要左节点在右节点之前即可
// 根据depth可以确定每个node所在的层
// 时间：O(N) 空间：O(1)
// class Solution {
// public:
//     vector<vector<int>> ans; // 将ans作为全局变量
//     vector<vector<int>> levelOrder(TreeNode* root) {
//         DFS(root, 0 /* depth */);
//         return ans;
//     }
//     void DFS(TreeNode* node, int depth) {
//         if (!node) return;
//         if (ans.size() == depth) ans.resize(depth+1);   // resize操作：
//         ans[depth].push_back(node->val); // 前序遍历;根据depth可以确定每个node所在的层
//         DFS(node->left, depth+1);
//         DFS(node->right, depth+1);
//     }
// };

// 附：C++容器的基础API
// resize操作：
// void resize (size_type n);
// void resize (size_type n, value_type val);
// resize函数重新分配大小，改变容器的大小，并且创建对象
// 当n小于当前size()值时候，vector首先会减少size()值 保存前n个元素，然后将超出n的元素删除(remove and destroy)
// 当n大于当前size()值时候，vector会插入相应数量的元素 使得size()值达到n，并对这些元素进行初始化，如果调用上面的第二个resize函数，指定val，vector会用val来初始化这些新插入的元素
// 当n大于capacity()值的时候，会自动分配重新分配内存存储空间。


 // 3. BFS解法
 // 使用两个vector-curr、next。其中curr是当前层节点，next是当前层节点的字节点。
// 时间：O(N) 空间：O(N)
 // C++使用：push_back()、back()、swap()、clear()
 // 来源：C/C++ - Map (STL) 用法與心得完全攻略 https://mropengate.blogspot.com/2015/12/cc-map-stl.html
class Solution {
public:
	vector<vector<int>> levelOrder(TreeNode* root) {
		if (!root) return {};
		return BFS(root);
	}
	vector<vector<int>> BFS(TreeNode* node) {
		vector<vector<int>> ans;
		vector<TreeNode*> curr,next;  // 借助两个容器，分别表示当前层和下一层
		curr.push_back(node);
		while(!curr.empty()) {
			ans.push_back({}); // 二维数组的第一维上进行占位
			for (TreeNode* child : curr) {
				if (child) ans.back().push_back(child->val); // 在二维数组的第一维上的最后一个子数组上插入元素
				if (child->left) next.push_back(child->left);
				if (child->right) next.push_back(child->right);
			}
			curr.swap(next); // 数组交换
			next.clear();    // 清空next数组
		}
		return ans;
	}
};

// 解法4.BFS解法
// 使用队列存储-FIFO
// O(N) O(N)
// 1.queue存储着当前层的所有节点；
// 2.遍历处理queue即当前层，为空则进入下一层即下一个循环；每一层的节点个数==queue内的节点个数
// 3.当前层queue的操作：获取队列头节点，处理完后，弹出头节点；整层处理完毕后，清理当前层的容器
class Solution {
public:
	vector<vector<int>> levelOrder(TreeNode* root) {
		if (!root) return {};
		return BFS(root);
	}
	vector<vector<int>> BFS(TreeNode* node) {
		vector<vector<int>> ans;
		vector<int> cur_level; // 依次存储每一层从左往右的结点值
		queue<TreeNode*> q;    // 队列，先进进出(FIFO)
		q.push(node);
		while(!q.empty()) {        // 树为空则直接返回
			int size = q.size();   // 每层的结点数
			for (int i = 0; i < size; ++i) {
				TreeNode* node = q.front();
				if (node) cur_level.push_back(node->val);  // 将现结点加入cur_level
				if (node->left) q.push(node->left);        // 非空结点不计入答案，所以要判断现结点的左右结点是否为空
				if (node->right) q.push(node->right);      // 非空结点不计入答案，所以要判断现结点的左右结点是否为空
				q.pop();                                   // 记得弹出已处理的队列结点
			}
			ans.push_back(cur_level);    // 把每层的结点存入ans
			cur_level.clear();           // 清除每层的结点，以便添加下一层的非空结点；如果将cur_level声明在while循环体内，则不用清理
		}
		return ans;
	}
};