class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        map = {}

        for i in range(len(nums)):
            rem = target -nums[i]

            if rem in map:
                return [map[rem], i]

            map[nums[i]] = i
        
        return []
        