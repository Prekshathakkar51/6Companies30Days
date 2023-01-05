class Solution {
    
        public int maxPoints(int[][] points) {
        int maxPoints=0;
        if(points.length<=2){return points.length;}
        //HashMap<Double,Integer> map=new HashMap<>();
        for(int i=0;i<points.length;i++){
            HashMap<Double,Integer> map=new HashMap<>();
            
            for(int j=0;j<points.length;j++){
                if(i==j){continue;}
        
                int x1=points[i][0];
                int y1=points[i][1];
                
                int x2=points[j][0];
                int y2=points[j][1];
                
                
                double k=(double)(y2 - y1)/(double)(x2 - x1);
                
                map.put(k,map.getOrDefault(k,1) + 1);
                
                maxPoints=Math.max(maxPoints,map.get(k));
            }
        }
        return maxPoints;
        }
    }