package io.shashanktyagi;

import java.util.Arrays;

public class ArrayPartitions1 {
    static class Solution {
        public int arrayPairSum(int[] nums) {
            Arrays.sort(nums);
            int res = 0;
            for (int i = 0; i < nums.length; i += 2) {
                res += nums[i];
            }
            return res;
        }
    }
}
