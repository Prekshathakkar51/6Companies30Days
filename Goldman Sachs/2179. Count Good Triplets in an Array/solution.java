class Solution {
    public long goodTriplets(int[] A, int[] B) {
        int n = A.length;
        int[] idx = new int[n];
        for(int i = 0; i < n; i++){
            idx[B[i]] = i;
        }
        int[] bit = new int[n+1];
        long ans = 0;
        for(int i = 0;i < n;i++){
            int pos = idx[A[i]];
            int l = query(bit, pos);
            int r = (n-1-pos) - (i - query(bit, pos));
            ans += 1L * l * r;
            update(bit, pos, 1);
        }
        return ans;
    }

    public int query(int[] bit, int i)
    {
        int sum = 0;
        for(i++; i > 0;i -= i&-i){
            sum += bit[i];
        }
        return sum;
    }

    public void update(int[] bit, int i, int v)
    {
        for(i++;i < bit.length;i += i&-i){
            bit[i] += v;
        } 
    }
}