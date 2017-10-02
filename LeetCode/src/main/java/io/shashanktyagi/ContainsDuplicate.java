package io.shashanktyagi;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    static class Solution {
        public boolean containsDuplicate(int[] nums) {
            return Arrays.stream(nums).distinct().count() < nums.length;
        }
    }
}
