import java.util.Stack;

public class daily_Temperatures {
    public static int[] dailyTemperatures(int[] temps) {
        int n = temps.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temps[i] > temps[stack.peek()]) {
                int idx = stack.pop();
                result[idx] = i - idx;
            }
            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] temps = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = dailyTemperatures(temps);
        for (int val : res) {
            System.out.print(val + " ");
        }
    }
}
