package io.shashanktyagi;

import java.util.Arrays;

@NotSolveYet
public class NextGreaterElement1 {
    static public class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            for (int i = 0; i < nums1.length; i++) {
                int j = i+1;
                for (; j < nums2.length && nums1[i] >= nums2[j]; j++) ;
                if (j < nums2.length) {
                    nums1[i] = nums2[j];
                } else {
                    nums1[i] = -1;
                }
            }
            return nums1;
        }
    }

    public static void main(String[] args) {
        int[] n1 = new int[]{4, 1, 2};
        int[] n2 = new int[]{1, 3, 4, 2};
        System.out.println(Arrays.toString(new Solution().nextGreaterElement(n1, n2)));
    }
}