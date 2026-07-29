class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for(int i=0;i<strs.length;i++){
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(strs[i]);

        }

        return new ArrayList<>(map.values());
    }
}
