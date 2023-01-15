class Solution {
    // O(n lg n) time, O(n) space
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        // min heap of incoming projects to choose available from them
        PriorityQueue<Project> incomingProjects = new PriorityQueue<>(Comparator.comparingInt(Project::getMinimumCapital));
        for(int i=0; i<profits.length; i++){
            incomingProjects.add(new Project(capital[i], profits[i]));
        }

        // max heap of available projects to choose one with highest profit 
        PriorityQueue<Project> availableProjects = new PriorityQueue<>(Comparator.comparingInt(Project::getProfit).reversed());
        int currentCapital = w;
        while(k > 0){
            // enqueue all available projects (minimumCapital <= currentCapital)
            while(!incomingProjects.isEmpty() && incomingProjects.peek().getMinimumCapital() <= currentCapital){
                availableProjects.add(incomingProjects.poll());
            }

            // pick next project and finish it
            if(!availableProjects.isEmpty()){
                Project project = availableProjects.poll();
                currentCapital += project.getProfit();
                k--;
            } else { // no project could be finished with current capital
                break;
            }
        }
        return currentCapital;
    }

    class Project {
        private int minimumCapital;
        private int profit;

        public Project(int minimumCapital, int profit){
            this.minimumCapital = minimumCapital;
            this.profit = profit;
        }

        public int getMinimumCapital(){
            return minimumCapital;
        }

        public int getProfit(){
            return profit;
        }
    }
}