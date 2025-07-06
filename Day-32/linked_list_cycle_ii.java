class Node3 {
    int val;
    Node3 next;

    Node3(int val) {
        this.val = val;
    }
}

public class linked_list_cycle_ii {
        public static Node3 detectCycle(Node3 head) {
            Node3 slow = head;
            Node3 fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;

                if (slow == fast) {
                    Node3 start = head;
                    while (start != slow) {
                        start = start.next;
                        slow = slow.next;
                    }
                    return start;
                }
            }

            return null;
        }


        public static void main(String[] args) {
            // Create a cycle: 3 -> 2 -> 0 -> -4
            //                        ^         |
            //                        |_________|
            Node3 n1 = new Node3(3);
            Node3 n2 = new Node3(2);
            Node3 n3 = new Node3(0);
            Node3 n4 = new Node3(-4);

            n1.next = n2;
            n2.next = n3;
            n3.next = n4;
            n4.next = n2;

            Node3 result = detectCycle(n1);
            System.out.println(result != null
                    ? "Cycle starts at node with value: " + result.val
                    : "No cycle found");
        }

}
