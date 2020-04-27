//方法1
class Solution {
public:
	void solveSudoku(vector<vector<char>>& board) {
		if (board.empty()) {
			return;
		}
		solve(board);
	}
	bool solve(vector<vector<char>>& board) {
		for (int i = 0; i < board.size(); i++) {
			for (int j = 0; j < board[0].size(); j++) {
				if (board[i][j] == '.') {
					for (char c = '1'; c <= '9'; c++) {
						if (IsValid(board, i, j, c)) {
							board[i][j] = c;
							if (solve(board)) {
								return true;
							}
							board[i][j] = '.';
						}
					}
					return false;
				}
			}
		}
		return true;
	}
	bool IsValid(vector<vector<char>>& board, int row, int col, char c) {
		for (int i = 0; i < 9; i++) {
			if (board[row][i] != '.' && board[row][i] == c)
				return false;
			if (board[i][col] != '.' && board[i][col] == c)
				return false;
			if (board[row/3*3 + i/3][col/3*3 + i%3] != '.' && board[row/3*3 + i/3][col/3*3 + i%3] == c)
				return false;
		}
		return true;
	}
};
//方法2
class Solution {
public:
	void solveSudoku(vector<vector<char>>& board) {		
		set<char> tmp;
		for (int i = 1; i <= 9; i++) {
			tmp.insert('0' + i);
		}
		for (int i = 0; i < 9; i++) {
			row.push_back(tmp);
			col.push_back(tmp);
			block.push_back(tmp);
		}
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					row[i].erase(board[i][j]);
					col[j].erase(board[i][j]);
					block[i / 3 * 3 + j / 3].erase(board[i][j]);
				}
				else
					empty.push_back(pair<int, int>(i, j));
			}
		}
		backTrack(board, 0);
	}
	bool backTrack(vector<vector<char>>& board, int level) {
		if (level == empty.size()) {
			return true;
		}

		int i = empty[level].first;
		int j = empty[level].second;
		int k = i / 3 * 3 + j / 3;
		set<char> tmp;
		set_intersection(row[i].begin(), row[i].end(), col[j].begin(), col[j].end(), inserter(tmp, tmp.begin()));
		unordered_set<char> tmp2;
		set_intersection(tmp.begin(), tmp.end(), block[k].begin(), block[k].end(), inserter(tmp2, tmp2.begin()));
		for (auto iter : tmp2) {
			if (col[j].find(iter) != col[j].end() && block[k].find(iter) != block[k].end()) {
				board[i][j] = iter;
				row[i].erase(iter);
				col[j].erase(iter);
				block[k].erase(iter);
				if (backTrack(board, level + 1))
					return true;
				row[i].insert(iter);
				col[j].insert(iter);
				block[k].insert(iter);
			}
		}
		return false;
	}
	vector<pair<int, int>> empty;
	vector<set<char>> row;
	vector<set<char>> col;
	vector<set<char>> block;
};
