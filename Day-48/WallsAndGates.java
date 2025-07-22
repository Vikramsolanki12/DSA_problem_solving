import java.util.*;

public class WallsAndGates {
    static final int INF = Integer.MAX_VALUE;

    public static void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0) return;

        int rows = rooms.length, cols = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (rooms[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] d : directions) {
                int r = cell[0] + d[0];
                int c = cell[1] + d[1];

                if (r < 0 || r >= rows || c < 0 || c >= cols || rooms[r][c] != INF) continue;

                rooms[r][c] = rooms[cell[0]][cell[1]] + 1;
                queue.add(new int[]{r, c});
            }
        }
    }

    public static void main(String[] args) {
        int INF = Integer.MAX_VALUE;
        int[][] rooms = {
                {INF, -1,  0, INF},
                {INF, INF, INF, -1},
                {INF, -1, INF, -1},
                {0,   -1, INF, INF}
        };

        wallsAndGates(rooms);

        for (int[] row : rooms) {
            System.out.println(Arrays.toString(row));
        }
    }
}
