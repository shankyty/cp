package io.shashanktyagi;

import java.util.Arrays;

public class DistrbuteCandies {
    static public class Solution {
        public int distributeCandies(int[] candies) {
            return Math.min(candies.length / 2, ((int) Arrays.stream(candies).distinct().count()));
        }
    }
}
