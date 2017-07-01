import java.util.*;

public class MazeWanderingEasy {

    private static int[] dx = new int[]{-1, 0, 1, 0};
    private static int[] dy = new int[]{0, 1, 0, -1};
    private Set<Point> visited = new HashSet<>();

    public int decisions(String[] maze) {
        Point start = null, end = null;
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length(); j++) {
                switch (maze[i].charAt(j)) {
                    case '*':
                        end = new Point(i, j);
                        break;
                    case 'M':
                        start = new Point(i, j);
                        break;
                }
            }
        }
        visited.add(start);
        return cnt(start, end, maze);
    }

    private int cnt(Point start, Point dest, String[] maze) {
        if (dest.equals(start)) {
            return 0;
        }
        int dcsn = -1;
        int deg = 0;
        for (int i = 0; i < 4; i++) {
            Point next = new Point(start.x + dx[i], start.y + dy[i]);
            if ((next.x >= 0 && next.x < maze.length)
                    && (next.y >= 0 && next.y < maze[0].length())
                    && ('.' == maze[next.x].charAt(next.y)
                    || '*' == maze[next.x].charAt(next.y)
                    || 'M' == maze[next.x].charAt(next.y))) {
                deg++;
                if (!visited.contains(next)) {
                    visited.add(next);
                    int c = cnt(next, dest, maze);
                    if (dcsn == -1) {
                        dcsn = c;
                    }
                }
            }
        }
        if ('M' == maze[start.x].charAt(start.y)) {
            deg++;
        }
        System.out.println("deg = " + deg + ",point = " + start + ",dscn = " + dcsn);
        return (dcsn != -1) ? (dcsn + ((deg > 2) ? 1 : 0)) : -1;
    }


    class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point point = (Point) o;

            if (x != point.x) return false;
            return y == point.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
