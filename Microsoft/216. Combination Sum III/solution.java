/*
1 ms
40.1 MB

TC : O(N)
SC : O(N)
*/

/**
 * @author : yashlondhe90960
 * @brief : backtracking
*/


class Solution {
    List<List<Integer>> result=new ArrayList();
    void try_combination(List<Integer> combination,int k,int n,int start){
        if(k==combination.size()){
            if(n==0) result.add(new ArrayList<Integer>(combination));
            return;
    
        }
        for(int i=start;i<=9;i++){
            combination.add(i);
            try_combination(combination,k,n-i,i+1);
            combination.remove(combination.size()-1);
    
    
        }
    }
    
        public List<List<Integer>> combinationSum3(int k, int n) {
            List<Integer> combination=new ArrayList();
            try_combination(combination,k,n,1);
            return result;
    
    
        }
    }