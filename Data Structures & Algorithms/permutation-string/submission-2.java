class Solution {
    public boolean checkInclusion(String s1, String s2) {
          
        int length1 = s1.length();
        int length2 = s2.length();
        if(length1>length2)
            return false;


        int[] have = new int[26];
        int[] need = new int[26];

        //build have
        for(char c: s1.toCharArray()){
            need[c-'a']++;
        }

        for(int right=0;right<length2;right++){
            have[s2.charAt(right)-'a']++;

            if(right>=length1){
                have[s2.charAt(right - length1)-'a']--;
            }

            boolean res = Arrays.equals(need, have);
            if(res)
                return true;
        }
        return false;
        
    }
}
