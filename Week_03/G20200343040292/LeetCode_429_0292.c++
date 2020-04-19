/*�ݹ�
ʱ�临�Ӷȣ�O(N)
�ռ临�Ӷȣ�������� O(logN)������ O(N)*/
/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> children;

    Node() {}

    Node(int _val) {
        val = _val;
    }

    Node(int _val, vector<Node*> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
public:
    vector<vector<int>> levelOrder(Node* root) {
        vector<vector<int>> res;
        recursion(root, 0, res);
        return res;
    }

    void recursion(Node* root, int level, vector<vector<int>>& res) {
        if (!root) {
            return;
        }

        if (level >= res.size())
            res.push_back(vector<int>());

        res[level].push_back(root->val);
        for (auto node : root->children) {
            recursion(node, level + 1, res);
        }
    }
};

/*�򻯵Ĺ����������
ʱ�临�Ӷȣ�O(N)
�ռ临�Ӷȣ�O(N)*/
class Solution {
public:
    vector<vector<int>> levelOrder(Node* root) {
        vector<vector<int>> res;
        if (!root)
            return res;
            
        vector<Node*> preLevel = {root};
        while (!preLevel.empty()) {
            vector<Node*> curLevel;
            res.push_back(vector<int>());
            for (auto node : preLevel) {
                res[res.size()-1].push_back(node->val);
                curLevel.insert(curLevel.end(), node->children.begin(), node->children.end());
            }
            preLevel = curLevel;
        }
        return res;
    }

  
};

/*���ö���ʵ�ֹ����������
ʱ�临�Ӷȣ�O(N)
�ռ临�Ӷȣ�O(N)*/
class Solution {
public:
    vector<vector<int>> levelOrder(Node* root) {
        vector<vector<int>> res;
        if (!root)
            return res;
        queue<Node*> q;
        q.push(root);

        while (!q.empty()) {
            vector<int> tmp;
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Node* node = q.front();
                q.pop();
                tmp.push_back(node->val);
                for (auto child : node->children)
                    q.push(child);
            }
            res.push_back(tmp);
        }
        return res;
    }
};