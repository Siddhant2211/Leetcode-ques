class Solution {
    public int superEggDrop(int K, int n) {
        int [] [] dp = new int [n + 1] [K + 1];
        int m = 0;
        while(dp [m] [K] < n){
            m++;
            for(int k = 1; k <= K; k++){
                dp [m] [k] = dp [m - 1] [k - 1] + dp [m - 1] [k] + 1;
            }
        }
        return m;
    }
}