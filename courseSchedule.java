class Solution {
    
    private List<Integer>[] convertToAdjList(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjList = new List[numCourses];
        for(int[] pair: prerequisites) {
            int course = pair[0];
            int pre = pair[1];
            if(adjList[pre] == null) {
                adjList[pre] = new ArrayList<Integer>();
            }
            adjList[pre].add(course);
        }
        return adjList;
    }
    
    private int[] prerequisitesList(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjList = new List[numCourses];
        for(int[] pair: prerequisites) {
            int course = pair[0];
            int pre = pair[1];
            if(adjList[course] == null) {
                adjList[course] = new ArrayList<Integer>();
            }
            adjList[course].add(pre);
        }
        
        int[] pList = new int[numCourses];
        for(int i = 0; i < adjList.length; i++) {
            if(adjList[i] == null) {
                pList[i] = 0;
            } else {
                pList[i] = adjList[i].size();
            }
        }
        return pList;
    }
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjList = convertToAdjList(numCourses, prerequisites);
        int[] pList = prerequisitesList(numCourses, prerequisites);
        int[] order = new int[numCourses];
        int index = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(pList[i] == 0) {
                order[index] = i;
                index++;
                queue.add(i);
                System.out.println(i);
            }
        }
        
        while(!queue.isEmpty()) {
            int course = queue.poll();
            if(adjList[course] != null) {
                for(int c: adjList[course]) {
                    pList[c]--;
                    if(pList[c] == 0) {
                        order[index] = c;
                        index++;
                        queue.add(c);
                    }
                }
            }
        }
        
        for(int pre: pList) {
            if(pre != 0) return new int[0];
        }
        
        return order;
        
    }
}
