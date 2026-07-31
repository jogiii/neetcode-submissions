class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        n = len(nums)

        for i in range(n):
            min =i
            for j in range(i+1,n):
                if nums[min]>nums[j]:
                    min =j
            
            temp = nums[i]
            nums[i] = nums[min]
            nums[min] = temp

        return nums