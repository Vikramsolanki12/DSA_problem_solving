public class selection_sort {
        public static void selectionSort(int[] arr) {
            int n = arr.length;

            for (int i = 0; i < n - 1; i++) {
                int minIdx = i;

                for (int j = i + 1; j < n; j++) {
                    if (arr[j] < arr[minIdx]) {
                        minIdx = j;
                    }
                }

                int temp = arr[minIdx];
                arr[minIdx] = arr[i];
                arr[i] = temp;
            }
        }

        public static void printArray(int[] arr) {
            for (int num : arr)
                System.out.print(num + " ");
            System.out.println();
        }

        public static void main(String[] args) {
            int[] nums = {64, 25, 12, 22, 11};


            selectionSort(nums);
            printArray(nums);
        }


}
