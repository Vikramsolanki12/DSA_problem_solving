import java.util.*;

public class RottenOranges {
    static class Pair {
        int x, y, time;
        Pair(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public static int orangesRotting(int[][] grid) {
        Queue<Pair> queue = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        int fresh = 0;
        int time = 0;


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Pair(i, j, 0));
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            time = p.time;

            for (int[] dir : directions) {
                int nx = p.x + dir[0];
                int ny = p.y + dir[1];

                if (nx >= 0 && ny >= 0 && nx < rows && ny < cols && grid[nx][ny] == 1) {
                    grid[nx][ny] = 2;
                    fresh--;
                    queue.add(new Pair(nx, ny, p.time + 1));
                }
            }
        }

        return (fresh == 0) ? time : -1;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {2,1,1},
                {1,1,0},
                {0,1,1}
        };
        System.out.println(orangesRotting(grid)); // Output: 4
    }
}
