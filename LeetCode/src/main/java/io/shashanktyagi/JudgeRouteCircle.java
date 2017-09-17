package io.shashanktyagi;

public class JudgeRouteCircle {
    static public class Solution {
        public boolean judgeCircle(String moves) {
            int up = 0;
            int left = 0;
            for (char move :
                    moves.toCharArray()) {
                switch (move) {
                    case 'U':
                        up++;
                        break;
                    case 'D':
                        up--;
                        break;
                    case 'L':
                        left++;
                        break;
                    case 'R':
                        left--;
                        break;
                }
            }
            return up == 0 && left == 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().judgeCircle("UD"));
        System.out.println(new Solution().judgeCircle("LL"));
    }
}
