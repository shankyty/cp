package io.shashanktyagi;

public class ReverseString {
    static public class Solution {
        public String reverseString(String s) {
            return new StringBuilder(s).reverse().toString();
        }

        public String reverseString2(String s) {
            char[] a = s.toCharArray();
            for (int i = 0, j = a.length; i <= j; i++, j--) {
                char tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }
            return new String(a);
        }
    }
}