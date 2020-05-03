class Solution {
public:
	class TrieNode {
	public:
		TrieNode() {};
		string word;
		unordered_map<char, TrieNode*> children;
	};

	vector<string> findWords(vector<vector<char>>& board, vector<string>& words) {
		TrieNode *root = new TrieNode();
		unordered_map<char, TrieNode*>::iterator iter;
		for (auto word : words) {
			TrieNode* node = root;
			for (auto letter : word) {
				iter = node->children.find(letter);
				if (iter != node->children.end()) {
					node = iter->second;
				} 
				else {
					TrieNode *new_Node = new TrieNode();
					node->children.insert(make_pair(letter, new_Node));
					node = new_Node;
				}
			}
			node->word = word;
		}

		this->board = board;
		for (int i = 0; i < board.size(); i++) {
			for (int j = 0; j < board[0].size(); j++) {
				if (root->children.find(board[i][j]) != root->children.end()) {
					backtracking(i, j, root);
				}
			}
		}
		return ans;
	}

	void backtracking(int row, int col, TrieNode *parent) {
		char letter = board[row][col];
		unordered_map<char, TrieNode*>::iterator iter;
		TrieNode *curNode = parent->children.find(letter)->second;
		
		if (!curNode->word.empty()) {
			ans.push_back(curNode->word);
			curNode->word = "";
		}

		if (curNode->children.empty()) {
			parent->children.erase(letter);
			return;
		}

		board[row][col] = '#';
		int row_offset[4] = {-1, 1, 0, 0};
		int col_offset[4] = {0, 0, 1, -1};
		for (int i = 0; i < 4; i++) {
			int new_Row = row + row_offset[i];
			int new_Col = col + col_offset[i];
			if (new_Row < 0 || new_Row >= board.size() || new_Col < 0 || new_Col >= board[0].size()) {
				continue;
			}
			if (curNode->children.find(board[new_Row][new_Col]) != curNode->children.end()) {
				backtracking(new_Row, new_Col, curNode);
			}
		}
		board[row][col] = letter;
	}
	vector<vector<char>> board;
	vector<string> ans;
};