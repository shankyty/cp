package io.shashanktyagi;

@NotSolveYet
public class MaximumSubarray {
    static public class Solution {
        public int maxSubArray(int[] nums) {
            for (int i = 1; i < nums.length; i++) {
                nums[i] = nums[i] + nums[i - 1];
            }
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                max = Math.max(nums[i], max);
                for (int j = i + 1; j < nums.length; j++) {
                    max = Math.max(nums[j] - nums[i], max);
                }
            }
            return max;
        }
    }

    public static void main(String[] args) {
        int[] x = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new Solution().maxSubArray(x));
        x = new int[]{1};
        System.out.println(new Solution().maxSubArray(x));
    }
}
