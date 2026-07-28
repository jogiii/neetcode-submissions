class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
         List<List<String>> res = new LinkedList<>();
        boolean[] visited = new boolean[strs.length];
        for(int i=0;i<strs.length;i++){
            if(visited[i])
                continue;

            List<String> group = new LinkedList<>();
            group.add(strs[i]);
            for(int j=i+1;j<strs.length;j++){

               boolean check= isAnagram(strs[i],strs[j]);
               if(!visited[j] && check){
                    group.add(strs[j]);
                    visited[j]=true;
               }

            }
            res.add(group);
            
        }
        return res;
        
    }

     public boolean isAnagram(String s, String t){
        if(s.length() != t.length())
            return false;

        char[] char_count = new char[26];

        for(int i=0;i<s.length();i++){
            char_count[s.charAt(i)-'a']++;
            char_count[t.charAt(i)-'a']--;
        }

        for(char count : char_count){
            if(count != 0)
                return false;
        }
        return true;
    }
}
