package io.shashanktyagi;

import java.util.Arrays;

public class MissingNumber {
    class Solution {
        public int missingNumber(int[] nums) {
            int n = nums.length;
            return ((n * (n + 1)) / 2) - Arrays.stream(nums).sum();
        }
    }
}
