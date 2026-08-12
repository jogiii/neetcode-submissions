class Solution {
    public int lastStoneWeight(int[] stones) {
        //create a priority queue
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        //add all the stones to the priority queue
        for(int stone : stones)
            pq.add(stone);
        
        while(pq.size()>1){
            int x = pq.poll(); // largest
            int y = pq.poll(); // second largest

            if(x!=y){
                pq.add(x-y);
            }
        }
        return pq.isEmpty() ? 0:pq.poll();
        
    }
}
