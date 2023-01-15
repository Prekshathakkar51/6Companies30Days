class Solution {
    public double knightProbability(int n, int k, int row, int column) { int[][] dirs = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {-1, -2}, {1, -2}, {-2, -1}};
        double[][] lastStep = new double[n][n];
        lastStep[row][column] = 1;

        for (; k > 0; k--) {
            double[][] currentStep = new double[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int[] dir : dirs) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if (x < 0 || x >= n || y < 0 || y >= n) continue;
                        currentStep[x][y] += lastStep[i][j] / 8.0;
                    }
                }
            }
            lastStep = currentStep;
        }

        double res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res += lastStep[i][j];
            }
        }

        return res; 
    }
}