class Solution {
    public int characterReplacement(String s, int k) {
        int [] freq =new int[26];
        int i=0;
        int max_freq=0;
        int res=0;
        for(int j=0;j<s.length();j++){
            freq[s.charAt(j)-'A']++;
            max_freq=Math.max(max_freq,freq[s.charAt(j)-'A']);
          
            while((j-i+1)-max_freq>k){
                freq[s.charAt(i)-'A']--;
                i++;

            }
            res=Math.max(res,j-i+1);
        }
        return res;
    }
}
