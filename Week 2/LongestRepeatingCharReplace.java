class Solution {
    public int characterReplacement(String s, int k) {
        int l=0, r=0;
        int res=0,maxFreq=0;
        int[] alpha = new int[26];
        while(r<s.length())
        {
            alpha[s.charAt(r)-'A']++;
            maxFreq=Math.max(maxFreq,alpha[s.charAt(r)-'A']);
            while(r-l-maxFreq+1>k)
            {
                alpha[s.charAt(l)-'A']--;
                l++;
            }
            res = Math.max(r-l+1,res);
            r++;
        }
        return res;
    }
}