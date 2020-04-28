class Solution:
    def findWords(self, board: list, words: list) -> list:
        trie = {}
        for word in words:
            t = trie
            for w in word:
                t = t.setdefault(w, {})
            t["end"] = 1
        res, row, col = [], len(board), len(board[0])

        def dfs(i, j, trie, s):
            c = board[i][j]
            if c not in trie:
                return
            trie = trie[c]
            if "end" in trie and trie["end"] == 1:
                res.append(s + c)
                trie["end"] = 0
            board[i][j] = "#"
            for x, y in [[-1, 0], [1, 0], [0, 1], [0, -1]]:
                tmp_i = x + i
                tmp_j = y + j
                if 0 <= tmp_i < row and 0 <= tmp_j < col and board[tmp_i][tmp_j] != "#":
                    dfs(tmp_i, tmp_j, trie, s + c)
            board[i][j] = c
        for i in range(row):
            for j in range(col):
                dfs(i, j, trie, "")
        return res