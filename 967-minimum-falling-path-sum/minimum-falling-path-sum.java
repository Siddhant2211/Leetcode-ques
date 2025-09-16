class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix [0].length;
        int [] [] dp = new int [n] [m];
        for(int j = 0; j < m; j++){
            dp [0] [j] = matrix [0] [j];
        }

        for(int i = 1; i < n; i++){
            for(int j = 0; j < m; j++){
                int up = matrix [i] [j] + dp [i - 1] [j];
                int left = matrix [i] [j];
                if(j - 1 >= 0){
                    left += dp [i - 1] [j - 1];
                }
                else{
                    left = Integer.MAX_VALUE;
                }
                int right = matrix [i] [j];
                if(j + 1 < m){
                    right += dp [i - 1] [j + 1];
                }
                else{
                    right = Integer.MAX_VALUE;
                }

                dp [i] [j] = Math.min(up, Math.min(left, right));
            }
        }

        int min = Integer.MAX_VALUE;
        for(int j = 0; j < m; j++){
            min = Math.min(min, dp [n - 1] [j]);
        }
        return min;
    }
}