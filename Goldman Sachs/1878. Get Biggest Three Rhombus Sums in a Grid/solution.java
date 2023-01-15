class Solution {
    public int[] getBiggestThree(int[][] grid) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                int k = 1;
                int sum = grid[i][j]; // add top center
                pq.add(sum);
                while(j-k >= 0 && j+k < grid[0].length && i+2*k < grid.length){
                    sum += grid[i+k][j+k] + grid[i+k][j-k] + grid[i+2*k][j]; // add top diagonals and bottom center
                    for(int l=1; l<k; l++) sum += grid[i+k+l][j-k+l] + grid[i+k+l][j+k-l]; // add bottom diagonals
                    pq.add(sum);
                    sum -= grid[i+2*k][j]; // remove bottom center
                    for(int l=1; l<k; l++) sum -= grid[i+k+l][j-k+l] + grid[i+k+l][j+k-l]; // remove bottom diagonals
                    k++;
                }
            }
        }
        
        List<Integer> resList = new ArrayList<>();
        while(!pq.isEmpty()){
            int popped = pq.remove();
            if(resList.size() == 0 || resList.size() > 0 && resList.get(resList.size()-1) != popped) resList.add(popped);
            if(resList.size() == 3) break;
        }
        
        int[] res = new int[resList.size()];
        for(int i=0; i<resList.size(); i++){
            res[i] = resList.get(i);
        }
        
        return res;
    }
}