
public class ThreeTeleports {

    public int shortestDistance(int xMe, int yMe, int xHome, int yHome, String[] teleports) {
        int[][] teles = new int[teleports.length][4];
        for (int i = 0; i < teleports.length; i++) {
            String[] cords = teleports[i].split(" ");
            for (int j = 0; j < cords.length; j++) {
                teles[i][j] = Integer.parseInt(cords[j]);
            }
        }
        int min = time(xMe, yMe, xHome, yHome);
        for (int i = 0; i < teleports.length; i++) {
            min = Math.min(
                    time(xMe, yMe, teles[i][0], teles[i][1]) + time(xHome, yHome, teles[i][2], teles[i][3]) + 10,
                    min
            );
            min = Math.min(
                    time(xMe, yMe, teles[i][2], teles[i][3]) + time(xHome, yHome, teles[i][0], teles[i][1]) + 10,
                    min
            );
        }
        return min;
    }

    private int time(int x1, int y1, int x2, int y2) {
        return Math.abs(x2 - x1) + Math.abs(y2 - y1);
    }
}
