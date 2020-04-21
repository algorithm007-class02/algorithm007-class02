#
# @lc app=leetcode.cn id=212 lang=python3
#
# [212] 单词搜索 II
#
# https://leetcode-cn.com/problems/word-search-ii/description/
#
# algorithms
# Hard (39.50%)
# Likes:    141
# Dislikes: 0
# Total Accepted:    12.6K
# Total Submissions: 31.4K
# Testcase Example:  '[["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]]\n["oath","pea","eat","rain"]'
#
# 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
#
#
# 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
#
# 示例:
#
# 输入:
# words = ["oath","pea","eat","rain"] and board =
# [
# ⁠ ['o','a','a','n'],
# ⁠ ['e','t','a','e'],
# ⁠ ['i','h','k','r'],
# ⁠ ['i','f','l','v']
# ]
#
# 输出: ["eat","oath"]
#
# 说明:
# 你可以假设所有输入都由小写字母 a-z 组成。
#
# 提示:
#
#
# 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？
# 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？
# 前缀树如何？如果你想学习如何实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。
#
#
#

# @lc code=start
class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        if not board or not board[0]: return []
        if not words: return []
        # 构建 Trie
        trie = {}
        for word in words:
            node = trie
            for char in word:
                node = node.setdefault(char, {})
            node['#'] = True
        # DFS
        def _dfs(i, j, node, pre, visited):
            if '#' in node:
                res.add(pre)
            for (di, dj) in ((-1,0), (1,0), (0, -1), (0, 1)):
                x, y = i+di, j+dj
                if 0 <= x < m and 0 <= y < n and board[x][y] in node and (x,y) not in visited:
                    _dfs(x, y, node[board[x][y]], pre+board[x][y], visited | {(x,y)})
        # 主逻辑
        res, m, n = set(), len(board), len(board[0])
        for i in range(m):
            for j in range(n):
                if board[i][j] in trie:
                    _dfs(i, j, trie[board[i][j]], board[i][j], {(i,j)})
        return list(res)
# @lc code=end
