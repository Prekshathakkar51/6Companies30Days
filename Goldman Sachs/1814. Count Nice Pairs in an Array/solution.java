class Solution {
    public int countNicePairs(int[] nums) {
        Map<Integer, Integer> map1 = new HashMap<>();
        long fans=0;
        int arr[] = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            arr[i]=reverse(nums[i]);
        }
        for(int i=0;i<nums.length;i++){
            map1.put(nums[i]-arr[i],map1.getOrDefault(nums[i]-arr[i],0)+1);

        }
        for(Map.Entry<Integer, Integer> e: map1.entrySet()){
            long n=e.getValue();
            fans=fans+(n*(n-1)/2);

        }
        System.out.println(map1);
        fans=fans%(1000000007);

        return (int)fans;
    }

      public int reverse(int num)
    {
        String str="";
        int ans=0;
        
        while(num>0)
        {

            str=str+num%10;
            num=num/10;



        }
        
         ans=parseStrToInt(str);

        
        return ans;
    }

    public int parseStrToInt(String str) {
        if (str.matches("\\d+")) {
            return Integer.parseInt(str);
        } else {
            return 0;
        }
    }
}