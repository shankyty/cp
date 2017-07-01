public class CellRemoval {

    public int cellsLeft(int[] parent, int deletedCell) {
        int root = 0;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == -1) {
                root = i;
            }
        }
        return r(parent, root, deletedCell);
    }

    private int r(int[] parent, int i, int deletedCell) {
        int cnt = 0;
        if (i == deletedCell)
            return cnt;
        if (i < parent.length) {
            for (int j = 0; j < parent.length; j++) {
                if (parent[j] == i)
                    cnt += r(parent, j, deletedCell);
            }
            if (cnt == 0) {
                cnt = 1;
            }
        }
        return cnt;
    }
}
