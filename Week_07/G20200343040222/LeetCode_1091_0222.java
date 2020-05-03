public class LeetCode_1091_0222 {

    /**
     * BFS 时间复杂度O(N) N为grid 数字数量 ，空间复杂度为O(1) queue 大小最大为8
     * @param grid
     * @return
     */
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if (grid[0][0] == 1 || grid[n - 1][m - 1] == 1) return -1;
        if (n == 1 && m == 1) return 1;
        int[] dx = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};
        grid[0][0] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                int[] data = queue.poll();
                if (data[0] == n - 1 && data[1] == m - 1) return count;
                for (int j = 0; j < 8; j++) {
                    int x = data[0] + dx[j];
                    int y = data[1] + dy[j];
                    if (x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == 0 ) {
                        queue.add(new int[]{x, y});
                        grid[x][y] = 1;
                    }
                }
            }
        }
        return -1;
    }

    /**
     * A*Search 搜索 时间复杂度O(N) N为grid 数字数量 空间复杂度为O(N) 创建N个Node结点
     */
    int n;
    public int shortestPathBinaryMatrix(int[][] grid) {
        n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;
        if (n == 1) return 1;
        int[] dx = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};
        Node start = new Node(0 ,0, grid[0][0] = 1);
        Queue<Node> queue = new PriorityQueue<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int step = grid[node.x][node.y];
            for (int i = 0; i < 8; i++) {
                int x = dx[i] + node.x;
                int y = dy[i] + node.y;
                if (x == n - 1 && y == n - 1) return step + 1;
                if (x < 0 || x >= n || y < 0 || y>= n) continue;
                if (grid[x][y] != 0 && grid[x][y] <= step + 1) continue;
                Node next = new Node(x, y, grid[x][y] = step + 1);
                queue.offer(next);
            }
        }
        return -1;
    }

    class Node implements Comparable<Node>{
        int x;
        int y;
        int f;
        public Node(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.f = Math.max(n - 1 - x, n - 1 - y) + step;
        }

        @Override
        public int compareTo(Node node) {
            return this.f - node.f;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node node = (Node)o;
            return x == node.x && y == node.y;
        }
        @Override
        public int hashCode() {
            return Integer.hashCode(x * n + y);
        }

    }
}