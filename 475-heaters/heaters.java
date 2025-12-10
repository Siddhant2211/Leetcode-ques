class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);

        int ans = 0;
        for(int house : houses){
            int idx = Arrays.binarySearch(heaters, house);
            if(idx < 0){
                idx = -idx - 1;
            }

            int right = (idx >= heaters.length ? Integer.MAX_VALUE : heaters [idx] - house);

            int left = ((idx - 1 < 0) ? Integer.MAX_VALUE : house - heaters [idx - 1]); 

            int c = Math.min(left, right);
            ans = Math.max(ans, c);
        }

        return ans;
    }
}