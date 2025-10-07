class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Map<Integer, Integer> lastRain = new HashMap<>();
        TreeSet<Integer> sunnyDays = new TreeSet<>();
        
        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) {
                sunnyDays.add(i);
                ans[i] = 1;
            } else {
                ans[i] = -1;
                if (lastRain.containsKey(rains[i])) {
                    Integer dryDay = sunnyDays.higher(lastRain.get(rains[i]));
                    if (dryDay == null) return new int[0];
                    ans[dryDay] = rains[i];
                    sunnyDays.remove(dryDay);
                }
                lastRain.put(rains[i], i);
            }
        }
        return ans;
    }
}