class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
       int gcd = numsDivide[0];
       for(int i=0;i<numsDivide.length;i++){
           gcd = helper(numsDivide[i],gcd);
       } 
       Arrays.sort(nums);
       int count =0;
       for(int i=0;i<nums.length;i++){
           if(gcd % nums[i]==0){
               return count;

           }
           else{
               count++;

           }
       }
       return -1;

    }
    public int helper(int a, int b){
        if(b==0){
            return a;
        }
        return helper(b,a%b);

    }
}