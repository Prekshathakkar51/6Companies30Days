public class Solution {
    public int minMutation(String start, String end, String[] bank) {

        if (start.equals(end)) {
            return 0;
        }

        // construct set
        Set<String> bankSet = new HashSet<>();
        bankSet.addAll(Arrays.asList(bank));

        char[] charSet = new char[]{'A', 'C', 'G', 'T'};

        int level = 0;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            int size = queue.size(); // get this level count
            while (size-- > 0) { // @note: this will gurantee go over all this level
                String curr = queue.poll();
                if (curr.equals(end)) {
                    return level;
                }

                char[] currArray = curr.toCharArray();
                for (int i = 0; i < currArray.length; i++) {

                    char old = currArray[i]; // save char in this index

                    for (char c : charSet) {
                        currArray[i] = c;
                        String next = new String(currArray);
                        if (!visited.contains(next) && bankSet.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                        }
                    }

                    currArray[i] = old; // restore after all above char trials
                }
            }
            level++;
        }

        return -1;
    }
}
