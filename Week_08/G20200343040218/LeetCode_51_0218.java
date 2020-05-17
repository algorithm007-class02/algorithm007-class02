class Solution {

    private int[][] dp;
    private List<List<String>> res = new ArrayList();

    public List<List<String>> solveNQueens(int n) {
        dp = new int[n][n];
        backTrace(0);
        return res;
    }

    private void backTrace(int row) {
        if (row >= dp.length) {
            addRes();
        }
        for (int col = 0; col < dp.length; col++) {
            if (isOk(row, col) ){
                dp[row][col] = 1;
                backTrace(row+1);
                dp[row][col] = 0;
            }
        }
    }

    private boolean isOk(int row, int col) {
        int leftUpR = row - 1;
        int leftUpC = col - 1;
        while(leftUpR >=0 && leftUpC >=0) {
            if (dp[leftUpR][leftUpC] == 1) { return false; }
            leftUpR--;
            leftUpC--;
        }
        int rightUpR = row - 1;
        int rightUpC = col + 1;
        while(rightUpR >=0 && rightUpC < dp.length) {
            if (dp[rightUpR][rightUpC] == 1) { return false; }
            rightUpC++;
            rightUpR--;
        }

        int UpR = row - 1;
        while(UpR >=0) {
            if (dp[UpR][col] == 1) { return false; }
            UpR--;
        }
        return true;
    }

    private void addRes() {
        List<String> list = new ArrayList();
        for (int row = 0; row < dp.length; row++) {
            String line = "";
            for (int col = 0; col < dp.length; col++) {
                if (dp[row][col] == 1) {
                    line += "Q";
                } else {
                    line += ".";
                }
            }
            list.add(line);
        }
        res.add(list);
    }
}