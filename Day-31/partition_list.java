class Node2 {
    int val;
    Node2 next;

    Node2(int val) {
        this.val = val;
    }
}
public class partition_list {
        public static Node2 partition(Node2 head, int x) {
            Node2 beforeHead = new Node2(0); // Dummy head for < x
            Node2 afterHead = new Node2(0);  // Dummy head for >= x

            Node2 before = beforeHead;
            Node2 after = afterHead;

            while (head != null) {
                if (head.val < x) {
                    before.next = head;
                    before = before.next;
                } else {
                    after.next = head;
                    after = after.next;
                }
                head = head.next;
            }

            after.next = null;
            before.next = afterHead.next;

            return beforeHead.next;
        }

        public static void printList(Node2 head) {
            while (head != null) {
                System.out.print(head.val + " ");
                head = head.next;
            }
            System.out.println();
        }

        public static void main(String[] args) {
            // Example: 1 → 4 → 3 → 2 → 5 → 2, x = 3
            Node2 head = new Node2(1);
            head.next = new Node2(4);
            head.next.next = new Node2(3);
            head.next.next.next = new Node2(2);
            head.next.next.next.next = new Node2(5);
            head.next.next.next.next.next = new Node2(2);

            Node2 result = partition(head, 3);
            printList(result);
        }

}
