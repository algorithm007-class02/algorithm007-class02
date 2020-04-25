class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> set = new HashSet<>();
        for (int[] obstacle : obstacles) {
            set.add(obstacle[0] + "," + obstacle[1]);
        }
        int x = 0;
        int y = 0;
        int flag = 1;
        int max = 0;
        for (int command : commands) {
            switch (command) {
                case -2:
                    if (flag == 1) {
                        flag = 4;
                    } else {
                        flag = flag - 1;
                    }
                    break;
                case -1:
                    if (flag == 4) {
                        flag = 1;
                    } else {
                        flag = flag + 1;
                    }
                    break;
                default:
                    if (flag == 1) {
                        for (int i = 0; i < command; i++) {
                            y = y + 1;
                            if (set.contains(x + "," + y)) {
                                y = y - 1;
                            }
                            max = Math.max(max, x * x + y * y);
                        }
                    } else if (flag == 2) {
                        for (int i = 0; i < command; i++) {
                            x = x + 1;
                            if (set.contains(x + "," + y)) {
                                x = x - 1;
                            }
                            max = Math.max(max, x * x + y * y);
                        }
                    } else if (flag == 3) {
                        for (int i = 0; i < command; i++) {
                            y = y - 1;
                            if (set.contains(x + "," + y)) {
                                y = y + 1;
                            }
                            max = Math.max(max, x * x + y * y);
                        }
                    } else if (flag == 4) {
                        for (int i = 0; i < command; i++) {
                            x = x - 1;
                            if (set.contains(x + "," + y)) {
                                x = x + 1;
                            }
                            max = Math.max(max, x * x + y * y);
                        }
                    }
            }
        }
        return max;
    }
}