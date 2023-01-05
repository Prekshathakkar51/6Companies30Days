//https://youtu.be/CL4NZAoOdpM

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length == 0) return true;
        
        boolean[][] adj = new boolean[numCourses][numCourses];
        for(int i = 0; i < prerequisites.length; i++){
            adj[prerequisites[i][0]][prerequisites[i][1]] = true;
        }
        
        boolean[] visited = new boolean[numCourses];
        boolean[] explored = new boolean[numCourses];
        for(int i = 0; i < numCourses; i++){
            if(!visited[i] && isCyclic(adj, i, visited, explored)){
                return false;
            }
        }
        
        return true;
    }
    
    boolean isCyclic(boolean[][] adj, int i, boolean[] visited, boolean[] explored){
        visited[i] = true;
        for(int j = 0; j < adj.length; j++){
            if(adj[i][j]){
                if(!visited[j]){
                    if(isCyclic(adj, j, visited, explored)) return true;
                }
                else if(!explored[j]) return true;
            }
        }
        explored[i] = true;
        return false;
    }
    
}