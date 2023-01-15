class Solution {
    public int numberOfBoomerangs(int[][] points) {
      int n=points.length;
      int res = 0;
      for(int i=0;i<n;i++)
      {
          //use map to count the number of points that have the same distance to point i
          Map<Integer, Integer> map = new HashMap<>();
          for(int j=0 ;j<n ;j++){
              if(j==i){
                  continue;
              }
              int dis = getDistance(points[i], points[j]);
              int count = map.getOrDefault(dis,0);
              map.put(dis, count+1);
          }
          // use the count info to update the result
          for(int count : map.values()){
              res += count * (count-1);
          }
      }  
      return res;
    }
    private int getDistance(int[] a, int[] b){
        int dx = a[0] - b[0];
        int dy = a[1] - b[1];
        return dx * dx + dy * dy;

    }
}