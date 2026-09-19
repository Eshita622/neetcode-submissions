class Solution {
    public int maxProduct(int[] nums) {
        int min=nums[0];
        int max=nums[0];
        int result=nums[0];


        for(int i=1;i<nums.length;i++){

            int tempMax = Math.max(nums[i], Math.max(nums[i]*max, nums[i]*min));
            int tempMin = Math.min(nums[i], Math.min(nums[i]*max, nums[i]*min));

            max=tempMax;
            min=tempMin;
            result = Math.max(result, max);
        }
        return result;

    }
}