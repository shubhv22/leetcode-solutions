public class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        long prev = Long.MIN_VALUE / 4;
        int ans = 0;
        for (int num : nums) {
            long low = (long)num - k;
            long high = (long)num + k;
            long pick = Math.max(low, prev + 1);
            if (pick <= high) {
                ans++;
                prev = pick;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxDistinctElements(new int[]{1,2,2,3,3,4}, 2));
        System.out.println(s.maxDistinctElements(new int[]{1,1,1,1}, 0));
    }
}
