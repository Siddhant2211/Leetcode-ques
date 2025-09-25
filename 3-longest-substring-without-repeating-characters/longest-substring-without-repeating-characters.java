class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int [] cnt = new int [128];
        int left = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            cnt [ch]++;
            while(cnt [ch] > 1){
                cnt [s.charAt(left)]--;
                left++;
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }


    
}