class Solution {
    public int countGoodNumbers(long n) {
        int MOD = 1000000007;
        return (int) (power(5, (n + 1) / 2) * power(4, n / 2) % MOD);
    }


    public static long power(long base, long exponent){
        int MOD = 1000000007;
        long result = 1;
        while (exponent > 0) {
            if (exponent % 2 != 0) {
                result = (result * base) % MOD;
            }

            base = (base * base) % MOD;
            exponent = exponent / 2; 
        }
        return result;
    }
}