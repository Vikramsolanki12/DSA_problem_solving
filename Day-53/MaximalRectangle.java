import java.util.*;

public class MaximalRectangle {
    public static int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;

        int maxArea = 0;
        int[] heights = new int[matrix[0].length];

        for (char[] row : matrix) {
            for (int j = 0; j < row.length; j++) {
                heights[j] = (row[j] == '1') ? heights[j] + 1 : 0;
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }
    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int[] h = Arrays.copyOf(heights, heights.length + 1);

        for (int i = 0; i < h.length; i++) {
            while (!stack.isEmpty() && h[i] < h[stack.peek()]) {
                int height = h[stack.pop()];
                int width = stack.isEmpty() ? i : (i - stack.peek() - 1);
                max = Math.max(max, height * width);
            }
            stack.push(i);
        }

        return max;
    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        System.out.println(maximalRectangle(matrix));
    }
}
