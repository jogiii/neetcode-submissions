class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        count = {}
        res = 0
        maxCount=0

        for i in nums:
            count[i] = count.get(i,0)+1
            if count[i] > maxCount:
                res = i
                maxCount = count[i]
        return res
        