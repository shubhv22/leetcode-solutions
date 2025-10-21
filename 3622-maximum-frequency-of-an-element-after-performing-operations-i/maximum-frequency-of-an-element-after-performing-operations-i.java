class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int ans = 1;
        int adjustable = 0;
        Map<Integer, Integer> count = new HashMap<>();
        TreeMap<Integer, Integer> line = new TreeMap<>();
        TreeSet<Integer> candidates = new TreeSet<>();
        for (int num : nums) {
            count.merge(num, 1, Integer::sum);
            line.merge(num - k, 1, Integer::sum);
            line.merge(num + k + 1, -1, Integer::sum);
            candidates.add(num);
            candidates.add(num - k);
            candidates.add(num + k + 1);
        }
        for (int x : candidates) {
            adjustable += line.getOrDefault(x, 0);
            int countNum = count.getOrDefault(x, 0);
            int needOps = adjustable - countNum;
            int freqIfTargetX = countNum + Math.min(numOperations, needOps);
            ans = Math.max(ans, freqIfTargetX);
        }
        return ans;
    }
}
