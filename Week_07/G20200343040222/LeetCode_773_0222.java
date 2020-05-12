public class LeetCode_773_0222 {


    /**
     * 常规BFS
     * @param board
     * @return
     */
    public int slidingPuzzle(int[][] board) {
        int[][] dir = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
        String end = "123450";
        String current  = toString(board);
        if (current.equals(end)) return 0;
        Queue<String> queue = new LinkedList<String>();
        queue.offer(current);
        Set<String> visited = new HashSet<>();
        visited.add(current);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                current = queue.poll();
                for (int j = 0;j < current.length(); j++) {
                    if (current.charAt(j) != '0') continue;
                    for (int index : dir[j]) {
                        char[] nextValue = current.toCharArray();
                        swap(nextValue, j , index);
                        String next = new String(nextValue);
                        if (next.equals(end)) return count + 1;
                        if (visited.contains(next)) continue;
                        queue.offer(next);
                        visited.add(next);
                    }
                    break;
                }
            }
            count++;
        }
        return -1;

    }

    private String toString(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        char[] value = new char[n * m];
        for (int i = 0; i < n * m; i++) {
            value[i] = (char)(board[i / m][i % m] + '0');
        }
        return new String(value);
    }

    private void swap(char[] arr, int i, int j) {
        if (i != j) {
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }


    /**
     * 滑动谜题
     * A* 搜索
     * @param board
     * @return
     */
    public int slidingPuzzleRe(int[][] board) {
        // 0 i位置时能移动到哪个位置的列表
        int[][] dir = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
        int[] endBoard = {1, 2, 3,4, 5, 0};
        Node curr = new Node(board);
        if (Arrays.equals(curr.board, endBoard)) return 0;
        PriorityQueue<Node> q = new PriorityQueue<> ();
        q.offer(curr);
        HashSet<Node> visited = new HashSet<>();
        visited.add(curr);
        while (!q.isEmpty()) {
            curr = q.poll();
            for (int nextZeroPos : dir[curr.zeroPos]) {
                int[] nextBoard = Arrays.copyOf(curr.board, 6);
                swap(nextBoard, curr.zeroPos, nextZeroPos);
                if (Arrays.equals(nextBoard, endBoard)) return curr.count + 1;
                Node next = new Node(nextBoard, nextZeroPos, curr.count + 1);
                if (visited.contains(next)) continue;
                q.offer(next);
                visited.add(next);
            }
        }
        return -1;
    }


    private void swap(int[] arr, int i, int j) {
        if (i != j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }

    class Node implements Comparable<Node>{
        int[] board;
        int zeroPos;
        int count;
        int distance;
        int f;

        public Node(int[][] board) {
            this.board = new int[6];
            for (int i = 0; i < 6; i++) {
                this.board[i] = board[i / 3][i % 3];
                if (this.board[i] == 0) this.zeroPos = i;
            }
            this.count = 0;
            this.distance = calcDistance();
            this.f = this.count + this.distance;
        }
        public Node(int[] board, int zeroPos, int count) {
            this.board = board;
            this.zeroPos = zeroPos;
            this.count = count;
            this.distance = calcDistance();
            this.f = this.count + this.distance;
        }

        private int calcDistance() {
            int distance = 0;
            for (int i = 0; i < 6; i++) {
                int v = board[i] - 1;
                distance += (Math.abs(v / 3 + i /3  ) + Math.abs(v % 3 - i % 3));
            }
            return distance;
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
            return zeroPos == node.zeroPos && Arrays.equals(board, node.board);
        }

        @Override
        public int hashCode(){
            int result = Objects.hash(zeroPos);
            result = 31 * result + Arrays.hashCode(board);
            return result;
        }
    }

}