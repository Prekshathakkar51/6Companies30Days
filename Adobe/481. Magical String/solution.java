class Solution {
    public int magicalString(int n) {
        String str = "122";
        if(n<=3) return 1;
        int count = 1; int prev=2;
        int left=2;
        int right=3;
        while(right<n){
            int times=Character.getNumericValue(str.charAt(left));
            int app = (prev==1)?2:1;
            right+=times;
            if(right==(n+1) && app==1){
                count++;
                return count;
            }
            if(app==1) count+=times;

            for(int i=1; i<=times; i++){
                str+=app;
            }
            left++;
            prev=app;
        }        
        return count;
    }
}