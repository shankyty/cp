package io.shashanktyagi;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllDuplicatesinanArray {
    public static final class Solution {
        public List<Integer> findDuplicates(int[] nums) {
            List<Integer> list = new ArrayList<>();
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                if (!set.contains(nums[i])) {
                    set.add(nums[i]);
                } else {
                    list.add(nums[i]);
                }
            }
            return list;
        }
    }
}
