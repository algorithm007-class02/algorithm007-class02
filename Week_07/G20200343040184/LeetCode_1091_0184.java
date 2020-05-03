/**
 * @lc app=leetcode.cn id=1091 lang=java
 */
class Solution {
    int n;
    public int shortestPathBinaryMatrix(int[][] grid) {
        n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;
        if (n == 1) return 1;
        int[][] dir = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1},
            {-1, 1}, {-1, -1}, {1, -1}, {1, 1}
        };
        Node start = new Node(0, 0, grid[0][0] = 1);
        Queue<Node> queue = new PriorityQueue<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int step = grid[node.x][node.y];
            for (int[] d : dir) {
                int x = node.x + d[0];
                int y = node.y + d[1];
                if (x == n - 1 && y == n - 1) return step + 1;
                if (x < 0 || x >= n || y < 0 || y >= n) continue;
                if (grid[x][y] != 0 && grid[x][y] <= step + 1) continue;
                Node next = new Node(x, y, grid[x][y] = step + 1);
                queue.offer(next);
            }
        }
        return -1;
    }

    class Node implements Comparable<Node> {
        int x;
        int y;
        int f;

        public Node(int x, int y, int step) {
            this.x = x;
            this.y = y;
            int distance = Math.max(n - 1 - x, n - 1 - y);
            this.f = distance + step;
        }

        @Override
        public int compareTo(Node o) {
            return this.f - o.f;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node node = (Node) o;
            return x == node.x && y == node.y;
        }

        @Override
        public int hashCode() {
            return Integer.hashCode(x * n + y);
        }
    }
}
// @lc code=end