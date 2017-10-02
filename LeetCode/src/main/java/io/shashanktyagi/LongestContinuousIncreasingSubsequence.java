package io.shashanktyagi;

public class LongestContinuousIncreasingSubsequence {
    static public class Solution {
        public int findLengthOfLCIS(int[] nums) {
            if(nums.length == 0)
                return 0;
            int cnt = 1;
            int res = 1;
            for(int i = 1; i < nums.length; i++){
                if(nums[i] > nums[i-1]){
                    cnt++;
                } else {
                    res = Math.max(cnt,res);
                    cnt = 1;
                }
            }
            return Math.max(cnt,res);
        }
    }
}
