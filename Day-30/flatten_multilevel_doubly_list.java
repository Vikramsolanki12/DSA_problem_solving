class Node1 {
    int val;
    Node1 prev;
    Node1 next;
    Node1 child;

    public Node1(int val) {
        this.val = val;
    }
}
public class flatten_multilevel_doubly_list {
        public static Node1 flatten(Node1 head) {
            if (head == null) return null;
            flattenDFS(head);
            return head;
        }

        private static Node1 flattenDFS(Node1 node) {
            Node1 current = node;
            Node1 last = null;

            while (current != null) {
                Node1 next = current.next;

                if (current.child != null) {
                    Node1 childHead = current.child;
                    Node1 childTail = flattenDFS(childHead);

                    current.next = childHead;
                    childHead.prev = current;

                    if (next != null) {
                        childTail.next = next;
                        next.prev = childTail;
                    }

                    current.child = null;
                    last = childTail;
                } else {
                    last = current;
                }

                current = next;
            }

            return last;
        }

        public static void printList(Node1 head) {
            while (head != null) {
                System.out.print(head.val + " ");
                head = head.next;
            }
            System.out.println();
        }

        public static void main(String[] args) {
            // Example:
            // 1 - 2 - 3 - 4 - 5 - 6
            //         |
            //         7 - 8 - 9 - 10
            //              |
            //              11 - 12

            Node1 n1 = new Node1(1);
            Node1 n2 = new Node1(2);
            Node1 n3 = new Node1(3);
            Node1 n4 = new Node1(4);
            Node1 n5 = new Node1(5);
            Node1 n6 = new Node1(6);
            Node1 n7 = new Node1(7);
            Node1 n8 = new Node1(8);
            Node1 n9 = new Node1(9);
            Node1 n10 = new Node1(10);
            Node1 n11 = new Node1(11);
            Node1 n12 = new Node1(12);

            n1.next = n2; n2.prev = n1;
            n2.next = n3; n3.prev = n2;
            n3.next = n4; n4.prev = n3;
            n4.next = n5; n5.prev = n4;
            n5.next = n6; n6.prev = n5;

            n3.child = n7;
            n7.next = n8; n8.prev = n7;
            n8.next = n9; n9.prev = n8;
            n9.next = n10; n10.prev = n9;

            n8.child = n11;
            n11.next = n12; n12.prev = n11;

            Node1 result = flatten(n1);
            printList(result); // Output: 1 2 3 7 8 11 12 9 10 4 5 6
        }

}
