import java.util.*;
import java.math.*;

import static java.lang.Math.*;

public class TheAirTripDivTwo {

    public int find(int[] flights, int fuel) {
        int i = 0;
        while (i < flights.length && fuel >= flights[i]) {
            fuel -= flights[i];
            i++;
        }
        return i;
    }
}
