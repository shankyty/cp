package io.shashanktyagi;

public class MaximumProductofThreeNumbers {
    public static class Solution {
        public int maximumProduct(int[] nums) {
            int pos = 1;
            int neg = 1;
            int maxNeg = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    pos *= nums[i];
                } else if (nums[i] < 0) {
                    neg *= nums[i];
                    maxNeg = Math.max(maxNeg, nums[i]);
                }
            }

            return pos * ((neg < 0) ? neg / maxNeg : neg);
        }
    }
}
