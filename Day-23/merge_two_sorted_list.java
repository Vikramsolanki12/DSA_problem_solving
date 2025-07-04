public class merge_two_sorted_list {
        public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(-1);
            ListNode current = dummy;

            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    current.next = l1;
                    l1 = l1.next;
                } else {
                    current.next = l2;
                    l2 = l2.next;
                }
                current = current.next;
            }

            current.next = (l1 != null) ? l1 : l2;

            return dummy.next;
        }

        public static void printList(ListNode head) {
            while (head != null) {
                System.out.print(head.val + " ");
                head = head.next;
            }
            System.out.println();
        }

        public static void main(String[] args) {
            // List 1: 1 -> 3 -> 5
            ListNode l1 = new ListNode(1);
            l1.next = new ListNode(3);
            l1.next.next = new ListNode(5);

            // List 2: 2 -> 4 -> 6
            ListNode l2 = new ListNode(2);
            l2.next = new ListNode(4);
            l2.next.next = new ListNode(6);

            ListNode merged = mergeTwoLists(l1, l2);
            printList(merged);
        }

}
