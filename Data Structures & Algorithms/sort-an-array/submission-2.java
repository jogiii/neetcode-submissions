class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            int min = i;
            for(int j=i+1;j<n;j++){
                if(nums[min] > nums[j]){
                    min = j;
                }
            }

            int temp = nums[i];
            nums[i] = nums[min];
            nums[min] = temp;
        }
    return nums;
        
    }
}