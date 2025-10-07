class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        HashMap<Integer, Integer> fullLake = new HashMap<>();
        TreeSet<Integer> dryDays = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) {
                dryDays.add(i);
                ans[i] = 1; // default value (can change later)
            } else {
                int lake = rains[i];
                ans[i] = -1; // raining day
                
                if (fullLake.containsKey(lake)) {
                    // Need to dry this lake before current day
                    int lastRainDay = fullLake.get(lake);
                    Integer dryDay = dryDays.higher(lastRainDay);
                    
                    if (dryDay == null) {
                        return new int[0]; // no dry day available → flood
                    }
                    
                    ans[dryDay] = lake; // dry this lake on that dry day
                    dryDays.remove(dryDay);
                }
                fullLake.put(lake, i); // mark this lake as full
            }
        }
        return ans;
        
    }
}