class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for(int i : nums) sum += i;
        if(sum % 2 != 0) return false;
        else{
            int k = sum / 2;
            boolean [] [] dp = new boolean [n] [k + 1];
            for(int i = 0; i < n; i++){
                dp [i] [0] = true;
            }
            if(nums [0] <= k){
                dp [0] [nums [0]] = true;
            }
            for(int i = 1; i < n; i++){
                for(int j = 1; j <= k; j++){
                    boolean notPick = dp [i - 1] [j];
                    boolean pick = false;
                    if(nums [i] <= j){
                        pick = dp [i - 1] [j - nums [i]];
                    }
                    dp [i] [j] = pick || notPick;
                }
            }
            return dp [n - 1] [k];
        }
    }
}