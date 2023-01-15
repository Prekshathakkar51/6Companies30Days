class Solution {
    
	// initial count is 2 for 0 and 1
    int cnt = 2;
    
    public int findIntegers(int n) {
        
        dfs(1, 1, n);
        return cnt;
    }
    
    public void dfs(int prev, int num, int n){
        
        //append 0
        if(num*2 <= n){
            cnt++;
            dfs(0, num*2, n);
        }
        
        //append 1
        if(prev == 0 && num*2+1 <= n){
            cnt++;
            dfs(1, num*2+1, n);
        }
    }
}