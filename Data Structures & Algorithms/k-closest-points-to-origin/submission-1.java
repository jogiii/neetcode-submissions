class Solution {
    public int[][] kClosest(int[][] points, int k) {


        PriorityQueue<int []> maxHeap = new PriorityQueue<>(
            (a,b) -> distSquared(b) - distSquared(a)
        );

        for(int[] point : points){
            maxHeap.offer(point);
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }

        int[][] result = new int[k][2];
        for(int i=0;i<k;i++){
            result[i] = maxHeap.poll();
        }        
        return result;

    }

    private int distSquared(int[] point){
        return point[0]* point[0]+point[1]*point[1];
    }
}
