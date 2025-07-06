class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}
public class reverse_linkedlist {
        public static ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;

            while (curr != null) {
                ListNode nextTemp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextTemp;
            }

            return prev;
        }

        public static void printList(ListNode head) {
            while (head != null) {
                System.out.print(head.val + " ");
                head = head.next;
            }
            System.out.println();
        }

        public static void main(String[] args) {
            ListNode head = new ListNode(1);
            head.next = new ListNode(2);
            head.next.next = new ListNode(3);

            System.out.print("Original: ");
            printList(head);

            ListNode reversed = reverseList(head);

            System.out.print("Reversed: ");
            printList(reversed);
        }

}
