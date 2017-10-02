package io.shashanktyagi;

public class NumberComplement {
    static class Solution {
        public int findComplement(int num) {
            int mask = 1 << 30;
            while ((mask & num) == 0) {
                mask = mask >> 1;
            }
            int res = 0;
            while (mask > 0) {
                int bit = mask & num;
                if (bit == 0) {
                    res = res | mask;
                }
                mask = mask >> 1;
            }
            return res;
        }
    }

    public int findComplement2(int num) {
        int mask = (Integer.highestOneBit(num) << 1) - 1;
        return num ^ mask;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findComplement(5));
    }
}
