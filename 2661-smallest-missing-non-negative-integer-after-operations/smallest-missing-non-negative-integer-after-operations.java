class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            int rem = ((num % value) + value) % value;
            count.put(rem, count.getOrDefault(rem, 0) + 1);
        }
        for (int i = 0; i < nums.length; i++) {
            int rem = i % value;
            int c = count.getOrDefault(rem, 0);
            if (c == 0) return i;
            count.put(rem, c - 1);
        }
        return nums.length;
    }
}
