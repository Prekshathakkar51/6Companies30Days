class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        int mi = Integer.MAX_VALUE;
        int count = 0;
        long sum = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                mi = Math.min(mi, Math.abs(matrix[i][j]));
                if(matrix[i][j] < 0){
                    count++;
                }
                sum += Math.abs(matrix[i][j]);
            }
        }
        if(count % 2 == 0){
            return sum;
        }
        return sum - 2 * (mi);
    }
}