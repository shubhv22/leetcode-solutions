class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int left = 0, right = n - 1;
        for(int k = n - 1; k >= 0; k-- ){
            int a = Math.abs(nums[left]);
            int b = Math.abs(nums[right]);
            if(a>b){
                res[k] = a * a;
                left++;
            }
            else{
                res[k] = b * b;
                right--;
            }
        }
        return res;
    }
}