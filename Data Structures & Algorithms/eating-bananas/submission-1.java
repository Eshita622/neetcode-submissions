class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];

        //maximum pile size
        for (int i = 1; i < piles.length; i++) {
            if (piles[i] > max) {
                max = piles[i];
            }
        }

        int low = 1;
        int high = max;
        int ans = max;

        //binary search for minimum eating speed
        while (low <= high) {
            int mid = low + (high - low) / 2;

            long hours = 0;

            //total hours
            for (int i = 0; i < piles.length; i++) {
                hours += (piles[i] +  (long)mid - 1) / mid;
            }

            if (hours <= h) {
                ans = mid;       // if speed works,try a smaller speed
                high = mid - 1;
            } else {
                low = mid + 1;   //if slow, increase speed
            }
        }

        return ans;
    }
}
