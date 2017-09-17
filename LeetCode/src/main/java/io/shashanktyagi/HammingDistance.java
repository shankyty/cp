package io.shashanktyagi;

public class HammingDistance {
    static class Solution {
        public int hammingDistance(int x, int y) {
            return Integer.bitCount(x ^ y);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().hammingDistance(1, 4) == 2);
        System.out.println(new Solution().hammingDistance(1, 28) == 2);
    }
}
