class Solution {
    public void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    
        
    }

    public static void quickSort(int[] nums, int low, int high){
        if (low<high){
            int pivotIndex = partition(nums, low, high);
            quickSort(nums, low, pivotIndex-1);
            quickSort(nums, pivotIndex+1,high);
        }
    }

    public static int partition(int[] nums, int low, int high){

        int pivot = nums[low];
        int i = low+1;
        int j = high;

        while(i <= j){
            while(i <=j && nums[i]<= pivot){
                i++;
            }

            while(i<=j && nums[j]> pivot){
                j--;
            }
            if(i<j){
                swap(nums, i,j);
            }
        }
        swap(nums, low, j);
        return j;

    }

        private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}