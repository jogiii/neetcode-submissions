class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        n = len(nums)

        for i in range(n-1):
            swapped = False
            for j in range(n-1-i):
                if nums[j]>nums[j+1]:
                    temp = nums[j];
                    nums[j] = nums[j+1]
                    nums[j+1] = temp
                    swapped = True

            if not swapped:
                break
        return nums