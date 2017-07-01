import java.util.*;
import java.math.*;

import static java.lang.Math.*;

public class FriendScore {

    public int highestScore(String[] friends) {
        boolean[][] aM = new boolean[friends.length][friends.length];
        for (int i = 0; i < friends.length; i++) {
            String friend = friends[i];
            for (int j = 0; j < friend.length(); j++) {
                aM[i][j] = aM[j][i] = friend.charAt(j) == 'Y';
            }
        }
        int[] con2 = new int[friends.length];
        for (int i = 0; i < friends.length; i++) {
            for (int j = i + 1; j < friends.length; j++) {
                if (aM[i][j]) {
                    con2[i]++;
                    con2[j]++;
                } else {
                    for (int k = 0; k < friends.length; k++) {
                        if (aM[i][k] && aM[k][j]) {
                            con2[i]++;
                            con2[j]++;
                            break;
                        }
                    }
                }
            }
        }
        return Arrays.stream(con2).max().getAsInt();
    }
}
