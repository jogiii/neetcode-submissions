class Solution {
    public int leastInterval(char[] tasks, int n) {
        int [] freq = new int[26];
        for(char task : tasks){
            freq[task -'A']++;
        }

        int maxfreq = 0;
        for(int f : freq){
            maxfreq = Math.max(maxfreq, f);
        }

        int maxCount = 0;
        for(int f : freq){
            if(f == maxfreq){
                maxCount++;
            }
        }

        int skeleton = (maxfreq-1)*(n+1)+maxCount;
        return Math.max(tasks.length, skeleton);
    }
}
