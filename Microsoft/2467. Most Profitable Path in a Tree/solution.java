class Solution {
    class Edge{
       int vtc;
       int nbr;
       int amt;
       Edge(int vtc, int nbr, int amt){
           this.vtc=  vtc;
           this.nbr = nbr;
           this.amt = amt;
       }
   }

       class Pair{
       int node;
       int time;
       int income;
       Pair(int node, int time, int income){
           this.node = node;
           this.time = time;
           this.income = income;
       }
   }


   public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
       ArrayList<ArrayList<Edge>> graph= new ArrayList<>();
       for(int i=0;i<amount.length;i++){
           graph.add(new ArrayList<>());
       }

       for(int e[] : edges){
           graph.get(e[0]).add(new Edge(e[0],e[1],amount[e[0]]));
           graph.get(e[1]).add(new Edge(e[1],e[0],amount[e[1]]));
       }

       boolean vis[] = new boolean[amount.length];
       
       HashMap<Integer, Integer> hm=new HashMap<>();
       dfs(graph,bob,0,hm,0,vis);

       int ans= Integer.MIN_VALUE;

       vis = new boolean[amount.length];
       Queue<Pair> q = new LinkedList<>();
       q.offer(new Pair(0,0,0));

       while(!q.isEmpty()){
           Pair p=q.poll();
           int node = p.node;
           vis[node]=true;
           int time =p.time;
           int income=p.income;
           if(hm.get(node)==null){
               income += amount[node];

           }
           else{
               if(time<hm.get(node)){
                   income+= amount[node];

               }
               else if(time ==hm.get(node)){
                   income+=(amount[node]/2);

               }
               else{
                   income+=0;

               }
           }

           if(node !=0 && graph.get(node).size()==1){
               ans= Math.max(ans,income);

           }

           for(Edge e: graph.get(node)){
               if(!vis[e.nbr]) q.offer(new Pair(e.nbr,time+1,income));

           }


       }
       return ans;
   }

       public boolean dfs(ArrayList<ArrayList<Edge>> graph, int src, int dest, HashMap<Integer,Integer> hm, int time, boolean vis[]){
       hm.put(src,time);
       if(src==dest) return true;
       vis[src] = true;
       for(Edge e : graph.get(src)){
           if(!vis[e.nbr]){
               if(dfs(graph,e.nbr, dest,  hm, time+1,vis)){
                   return true;
               }
           }
       }
       hm.remove(src);
       return false;
   }
}