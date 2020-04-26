/**
 * 单词搜索
 */
public class LeetCode_212_0222 {

    int rows = 0;
    int cols = 0;
    int[] dx = new int[]{-1, 1, 0 ,0};
    int[] dy = new int[]{0, 0, -1, 1};

    /**
     * 暴力法，dfs
     * 时间复杂度O(N*M*4^k) N为words数组的大小   M 为board的大小 k为words的平均长度
     * findWords 方法循环N
     * exists 方法循环为M
     * existsRecursive 循环为4M(最差)
     * 所以总的时间复杂度为 O(N*M*M)
     * 空间复杂度为O(N*k) k为每个字母的长度
     * @param board
     * @param words
     * @return
     */
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        this.rows = board.length;
        if (rows == 0) return res;
        this.cols = board[0].length;
        for (String word : words) {
            if (exists(word, board)) res.add(word);
        }
        return res;
    }

    private boolean exists(String word, char[][] board) {
        char[] wordChar = word.toCharArray();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (existsRecursive(board, i, j, wordChar, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean existsRecursive(char[][] board, int x, int y, char[] wordChar, int index) {
        if (x < 0 || x >= rows || y < 0 || y >= cols) {
            return false;
        }
        if (board[x][y] != wordChar[index]) {
            return false;
        }
        if (index == wordChar.length - 1) {
            return true;
        }
        for (int i = 0; i < 4; i++) {
            char temp = board[x][y];
            board[x][y] = '0';
            boolean isExists = existsRecursive(board, x + dx[i], y + dy[i], wordChar, index + 1);
            board[x][y] = temp;
            if (isExists) {
                return true;
            }
        }
        return false;
    }





    int rows;
    int cols;
    int[] dx = new int[]{-1, 1, 0 ,0};
    int[] dy = new int[]{0, 0, -1, 1};

    /**
     * 用字典树构造查询
     * 时间复杂度分析
     * 将字符串插入Trie树的时间复杂度N * k 设 N为words大小 AVGL为words 字符串平均长度
     * 遍历board 查询Trie树 M*(4^k)
     * 所以总时间复杂度为O(N*k + M*(4^k))
     * @param board
     * @param words
     * @return
     */
    public List<String> findWordsRe(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        this.rows = board.length;
        if (rows == 0) return res;
        this.cols = board[0].length;
        Trie trie  = new Trie();
        // 字符串插入Trie树
        for (String word : words) {
            trie.insert(word);
        }
        // 遍历board 查询Trie树
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                existsRecursiveRe(board, i, j, trie, res);
            }
        }
        return res;
    }

    private void existsRecursiveRe(char[][] board, int x, int y, Trie trie, List<String> res) {
        if (x < 0 || x >= rows || y < 0 || y >= cols) {
            return;
        }
        char currentChar = board[x][y];
        if (currentChar == '0' || trie.node[currentChar - 'a'] == null) {
            return;
        }
        trie = trie.node[currentChar - 'a'];
        if (trie.endString != null) {
            res.add(trie.endString);
            trie.endString = null;
        }
        for (int i = 0; i < 4; i++) {
            char temp = board[x][y];
            board[x][y] = '0';
            existsRecursiveRe(board, x + dx[i], y + dy[i], trie, res);
            board[x][y] = temp;
        }
    }

    class Trie {

        public String endString;

        public Trie[] node = new Trie[26];

        public Trie() {}

        public void insert(String word){
            Trie root = this;
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (root.node[chars[i] - 'a'] == null) {
                    root.node[chars[i] - 'a'] = new Trie();
                }
                root = root.node[chars[i] - 'a'];
            }
            root.endString = word;
        }

    }
}