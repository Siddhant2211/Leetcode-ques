class Solution {
    public int totalMoney(int n) {
        if(n <= 7){
            return (n * (n + 1)) / 2;
        }

        int x = n / 7;
        int ans = 0;
        for(int i = 1; i <= x; i++){
            int y = i;
            for(int j = 1; j <= 7; j++){
                ans += y;
                y = y + 1;
            }
        }



        if(n % 7 != 0){
            int z = (n / 7) + 1;
            for(int i = 1; i <= n % 7; i++){
                ans += z;
                z = z + 1;
            }
        }


        return ans;
    }
}