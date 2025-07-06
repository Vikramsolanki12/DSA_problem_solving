public class Convert_binary_to_integer_LinkedList {
    public static int getDecimalValue(ListNode head) {
        int result = 0;

        while (head != null) {
            result = (result << 1) | head.val;
            head = head.next;
        }

        return result;
    }

    public static void main(String[] args) {
        // Example: binary 101 => decimal 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(1);

        int result = getDecimalValue(head);
        System.out.println("Decimal Value: " + result);
    }
}
