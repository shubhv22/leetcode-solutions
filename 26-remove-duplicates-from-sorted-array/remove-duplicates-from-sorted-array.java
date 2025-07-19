class Solution {
    public int removeDuplicates(int[] nums) {
        int s=0;
        int n=nums.length;
        for(int i=1; i<n; i++){
            if(nums[i] != nums[s]){
                s++;
                nums[s]=nums[i];
            }
        }
        return s+1;
    }
}