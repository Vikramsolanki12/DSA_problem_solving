class Node {
    int val;
    Node next;
    Node random;

    Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class copyList_with_random_pointer {
        public static Node copyRandomList(Node head) {
            if (head == null) return null;

            Node curr = head;
            while (curr != null) {
                Node newNode = new Node(curr.val);
                newNode.next = curr.next;
                curr.next = newNode;
                curr = newNode.next;
            }

            curr = head;
            while (curr != null) {
                if (curr.random != null)
                    curr.next.random = curr.random.next;
                curr = curr.next.next;
            }

            curr = head;
            Node dummyHead = new Node(0);
            Node copy = dummyHead;

            while (curr != null) {
                Node nextOrig = curr.next.next;

                copy.next = curr.next;
                copy = copy.next;

                curr.next = nextOrig;
                curr = nextOrig;
            }

            return dummyHead.next;
        }

        public static void printList(Node head) {
            while (head != null) {
                int randVal = (head.random != null) ? head.random.val : -1;
                System.out.println("Node: " + head.val + ", Random: " + randVal);
                head = head.next;
            }
        }

        public static void main(String[] args) {
            // Creating list: 7 -> 13 -> 11 -> 10 -> 1
            Node n1 = new Node(7);
            Node n2 = new Node(13);
            Node n3 = new Node(11);
            Node n4 = new Node(10);
            Node n5 = new Node(1);

            n1.next = n2;
            n2.next = n3;
            n3.next = n4;
            n4.next = n5;

            n2.random = n1;
            n3.random = n5;
            n4.random = n3;
            n5.random = n1;

            Node copied = copyRandomList(n1);
            printList(copied);
        }

}
