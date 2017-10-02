package io.shashanktyagi;

import sun.misc.Unsafe;

public class ReverseWordsInAString3 {
    static public class Solution {
        public String reverseWords(String s) {
            String[] words = s.split(" ");
            StringBuilder out = new StringBuilder(s.length());
            for (String word : words) {
                for (int i = word.length() - 1; i >=0; i--) {
                    out.append(word.charAt(i));
                }
                out.append(' ');
            }
            return out.delete(out.length() -1,out.length()).toString();
        }
    }

    public static void main(String[] args) {
        Unsafe.getUnsafe();
        System.out.println(new Solution().reverseWords("Let's take LeetCode contest"));
    }
}
