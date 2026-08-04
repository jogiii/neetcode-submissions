class Solution {

    /**
 * QuickSort Algorithm (pivot = first element)
 * ---------------------------------------------
 * QuickSort is a divide-and-conquer sorting algorithm.
 *
 * Steps:
 * 1. Pick a pivot element. Here, we always choose the FIRST element
 *    of the current sub-array (arr[low]) as the pivot.
 * 2. Partition the array around the pivot so that:
 *    - All elements smaller than or equal to the pivot go to its left.
 *    - All elements greater than the pivot go to its right.
 *    After partitioning, the pivot lands in its correct sorted position.
 * 3. Recursively apply steps 1-2 to the sub-array of elements
 *    to the left of the pivot.
 * 4. Recursively apply steps 1-2 to the sub-array of elements
 *    to the right of the pivot.
 * 5. Base case: a sub-array with 0 or 1 elements is already sorted
 *    (low >= high), so recursion stops.
 *
 * Partitioning logic used in this implementation (Hoare-like, pivot fixed at low):
 *   a. Set pivot = arr[low], i = low + 1, j = high.
 *   b. Move i rightward while arr[i] <= pivot.
 *   c. Move j leftward while arr[j] > pivot.
 *   d. If i < j, swap arr[i] and arr[j] (they are out of place) and continue.
 *   e. When i > j, swap the pivot (arr[low]) with arr[j] — this places the
 *      pivot at index j, which is now its final sorted position.
 *   f. Return j as the pivot's index for recursive calls.
 *
 * Time Complexity:
 *   - Best/Average case: O(n log n)
 *   - Worst case: O(n^2)  (e.g., when the array is already sorted and pivot
 *     is always the first/smallest element, causing unbalanced partitions)
 * Space Complexity: O(log n) average (recursion stack), O(n) worst case.
 */

    private final Random random = new Random();

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(nums, low, high);

            quickSort(nums, low, pivotIndex - 1);
            quickSort(nums, pivotIndex + 1, high);
        }
    }

    private int partition(int[] nums, int low, int high) {

        int pivot = nums[low];
        int i = low+1;
        int j = high;

        while(i<=j){
            while(i<=j && nums[i]<= pivot){
                i++;
            }
            while(i<=j && nums[j]>pivot){
                j--;
            }
            if(i<j){
                swap(nums,i,j);
            }
        }

        swap(nums,low,j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}