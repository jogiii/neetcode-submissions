class Solution {
    public boolean checkInclusion(String s1, String s2) {
          int length1 = s1.length();
        int length2 = s2.length();

        if(length1>length2)
            return false;


        char[] sorted1 = s1.toCharArray();
        Arrays.sort(sorted1);

        for(int i=0;i<=length2-length1;i++){
            char[] window = s2.substring(i, i+length1).toCharArray();
            Arrays.sort(window);
            if(Arrays.equals(window, sorted1))
                return true;
        }
        return false;
        
    }
}
