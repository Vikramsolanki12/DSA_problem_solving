public class delete_node_in_linkedList {
    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        // List: 4 -> 5 -> 1 -> 9, delete node with value 5
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);


        deleteNode(head.next);

        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
