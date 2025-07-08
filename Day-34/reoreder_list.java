public class reoreder_list {
        static class ListNode {
            int val;
            ListNode next;
            ListNode(int val) { this.val = val; }
        }

        public static void reorderList(ListNode head) {
            if (head == null || head.next == null) return;

            ListNode slow = head, fast = head;
            while (fast != null && fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            ListNode second = reverse(slow.next);
            slow.next = null;

            ListNode first = head;
            while (second != null) {
                ListNode tmp1 = first.next;
                ListNode tmp2 = second.next;
                first.next = second;
                second.next = tmp1;
                first = tmp1;
                second = tmp2;
            }
        }

        private static ListNode reverse(ListNode head) {
            ListNode prev = null;
            while (head != null) {
                ListNode nextNode = head.next;
                head.next = prev;
                prev = head;
                head = nextNode;
            }
            return prev;
        }

        public static void main(String[] args) {

            // Linked List: 1 → 2 → 3 → 4
            ListNode head = new ListNode(1);
            head.next = new ListNode(2);
            head.next.next = new ListNode(3);
            head.next.next.next = new ListNode(4);

            reorderList(head);

            // Expected Output: 1 → 4 → 2 → 3
            while (head != null) {
                System.out.print(head.val + " ");
                head = head.next;
            }
        }
}
