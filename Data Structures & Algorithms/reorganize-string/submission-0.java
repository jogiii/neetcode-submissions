class Solution {
    public String reorganizeString(String s) {
        int[] hash = new int[26];
        for (int i=0; i<s.length(); i++) {
            hash[s.charAt(i) - 'a']++;
        }

        int max=0;
        int letter=0;
        for(int i=0;i<hash.length;i++) {
            if(hash[i]>max) {
                max=hash[i];
                letter=i;
            }
        }

        if(max >(s.length()+1)/2) return "";
        char[] res = new char[s.length()];

        //fill all the even places with majority character
        // Note: no idx-bounds/wrap check needed here - since max <= ceil(n/2),
        // the majority char's count can never exceed the number of even slots
        // (0, 2, 4, ...), so idx will always land within bounds during this loop.
        int idx = 0;
        while(hash[letter]-- > 0) {
            res[idx] = (char)(letter+'a');
            idx += 2;
        }

        // fill the remaining characters
        for(int i=0;i<hash.length;i++) {
            while(hash[i]-- >0){
                if(idx >= res.length) idx=1;
                res[idx] = (char)(i +'a');
                idx +=2;
            }
        }

        return new String(res);
        
    }
}