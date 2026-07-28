class Solution {
     public int majorityElement(int[] nums){

        int n =nums.length;
        int majority = n/2;
        Map<Integer,Integer> map =countElement(nums);

        for(int key: map.keySet()){
            if (map.get(key) > majority)
                return key ;
        }
        return 0;



    }

    public Map<Integer,Integer> countElement(int[] nums){
        Map<Integer, Integer> countMap = new HashMap<>();

        for(int num : nums){
            if(countMap.containsKey(num)){
                countMap.put(num, countMap.get(num)+1);
            }else{
                countMap.put(num, 1);
            }
        }

        return countMap;
        
    }
}