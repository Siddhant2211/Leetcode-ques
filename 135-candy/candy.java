class Solution {
    public int candy(int[] ratings) {
        int cnt1 = 0;
        int cnt2 = 0;
        int peak = 0;
        int ans = 1;


        for(int i = 1; i < ratings.length; i++){
            if(ratings [i - 1] < ratings [i]){
                cnt1++;
                cnt2 = 0;
                peak = cnt1 + 1;
                ans += peak;
            }

            else if(ratings [i - 1] == ratings [i]){
                cnt1 = 0;
                cnt2 = 0;
                peak = 0;
                ans++;
            }

            else{
                cnt1 = 0;
                cnt2++;
                ans += cnt2 + (peak > cnt2 ? 0 : 1);
            }
        }

        return ans;
    }
}