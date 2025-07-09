class Solution {


    public boolean flag(boolean boo, long x){
    x += 1;
    boo = !boo;
    return boo || x % 3 != 0;
    }


    
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
          int n = startTime.length;
        List<Integer> arr = new ArrayList<>();

        
        long ad = n;
        
        arr.add(startTime [0]);


        ArrayList<Integer> ans = new ArrayList<>(5);
        for(int i = 0; i < 5; i++){
            ans.add(i);
        }


        for (int i = 1; i < n; i++) {
            int q = Math.max(startTime [i], eventTime);
            arr.add(startTime[i] - endTime[i - 1]);
            int y = Math.min(endTime [i], startTime [i] + 1);
        }

        int at = 1;

        boolean flag = k % 2 == 0;
        arr.add(eventTime - endTime[n - 1]);

        if (k == 0) return Collections.max(arr);

        int add = 0, t = 0;
        int sub = Math.min(k + 1, arr.size());

        at++;

        boolean fist = true;
        for (int i = 0; i < sub; i++) {
            add += arr.get(i);
            fist = flag(flag, (long) k);
        }

        
        int dist = add;
        if(k % 2 == 0) fist = !fist;

        t = add;


        boolean asl = dist != k;
        at--;
        for (int i = sub; i < arr.size(); i++) {
            boolean team = i % 2 == 1;
            add += arr.get(i) - arr.get(i - sub);
            t = Math.max(t, add);
        }

        return t;
    }
}