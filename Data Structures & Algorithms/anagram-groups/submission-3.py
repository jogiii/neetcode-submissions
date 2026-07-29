class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        map = {}

        for i in strs:
            key = ''.join(sorted(i))

            if key not in map:
                map[key] = []
            
            map[key].append(i)
        return list(map.values())
        