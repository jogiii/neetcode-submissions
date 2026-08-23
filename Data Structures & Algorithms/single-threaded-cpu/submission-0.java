class Solution {
    public int[] getOrder(int[][] tasks) {

        int n = tasks.length;
        int[][] indexedTasks = new int[n][3];

        for(int i=0;i< n;i++){
            indexedTasks[i][0] = tasks[i][0];
            indexedTasks[i][1] = tasks[i][1];
            indexedTasks[i][2] = i;
        }
        //sort task by enqueue time
         Arrays.sort(indexedTasks, (a, b) -> a[0] - b[0]);

         PriorityQueue<int[]> available = new PriorityQueue<>(
            (a,b) -> {
                if(a[1] != b[1])
                    return a[1]-b[1]; //shorter processing time first
                return a[2]-b[2]; // tie break smaller index first

            }
         );

         int[] result = new int[n];
         int resultIndex = 0;
         int i = 0;
         int currentTime = 0;

         while(resultIndex < n){

// If no tasks are currently available and the next task hasn't
            // arrived yet, the CPU is idle -> jump forward in time to when
            // the next task becomes available (no need to tick one by one).
            if(available.isEmpty() && i<n && indexedTasks[i][0] > currentTime){
                currentTime = indexedTasks[i][0];
            }
             // Push every task that has arrived by currentTime into the heap.

             while(i < n && indexedTasks[i][0] <= currentTime){
                available.offer(indexedTasks[i]);
                i++;
             }

             //pick the best available task
             int[] choosen = available.poll();

             //record the task original index
             result[resultIndex++] = choosen[2];
             currentTime = currentTime +choosen[1];
         }

         return result;
        
    }
}