class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}
public class remove_linked_list_elements {
        public static ListNode removeElements(ListNode head, int val) {
            ListNode dummy = new ListNode(0); // Dummy node
            dummy.next = head;
            ListNode current = dummy;

            while (current.next != null) {
                if (current.next.val == val)
                    current.next = current.next.next;
                else
                    current = current.next;
            }

            return dummy.next;
        }
    public static void main(String[] args) {

        // Linked List: 1 -> 2 -> 6 -> 3 -> 4 -> 5 -> 6
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);

        ListNode result =removeElements(head, 6);


        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

}
