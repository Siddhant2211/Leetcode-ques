class Solution {

    public int houseRobber1(int [] nums){
        int n = nums.length;
        int [] dp = new int [n];
        Arrays.fill(dp, -1);
        dp [0] = nums [0];
        for(int i = 1; i < n; i++){
            int pick = nums [i];
            if(i > 1){
                pick += dp [i - 2];
            }
            int nonPick = dp [i - 1];
            dp [i] = Math.max(pick, nonPick);
        }
        return dp [n - 1];
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums [0];
        int [] arr1 = new int [n - 1];
        int [] arr2 = new int [n - 1];
        int idx1 = 0;
        int idx2 = 0;
        for(int i = 0; i < n; i++){
            if(i != 0) arr1 [idx1++] = nums [i];
            if(i != n - 1) arr2 [idx2++] = nums [i];
        }
        
        int ans1 = houseRobber1(arr1);
        int ans2 = houseRobber1(arr2);
        return Math.max(ans1, ans2);
    }
}