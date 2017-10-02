package io.shashanktyagi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBuzz {
    static public class Solution {
        public List<String> fizzBuzz(int n) {
            List<String> res = new ArrayList<>(n);
            for (int i = 1; i <= n; i++) {
                StringBuilder sb = new StringBuilder(12);

                if (i % 3 == 0) {
                    sb.append("Fizz");
                }
                if (i % 5 == 0) {
                    sb.append("Buzz");
                }
                if (i % 3 != 0 && i % 5 != 0) {
                    sb.append(i);
                }
                res.add(sb.toString());
            }
            return res;
        }

        public List<String> fizzBuzz8(int n) {
            return IntStream.range(1, n + 1).mapToObj(i -> new StringBuilder(12).append(i % 3 == 0 ? "Fizz" : "").append(i % 5 == 0 ? "Buzz" : "").append(
                    (i % 3 != 0 && i % 5 != 0) ? i : "").toString()).collect(Collectors.toList());
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().fizzBuzz8(15));
    }
}
