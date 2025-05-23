class Solution {
    public long gridGame(int[][] grid) {
        long ans = Long.MAX_VALUE;
    long firstRow = 0;
    long secRow = 0;
    for(int j = 0; j < grid [0].length; j++){
        firstRow += grid [0] [j];
    }

        for(int j = 0; j < grid [0].length; j++){
            firstRow -= grid [0] [j];
            ans = Math.min(ans, Math.max(firstRow, secRow));
            secRow += grid [1] [j];
        }
        
        
        return ans;
    }
}