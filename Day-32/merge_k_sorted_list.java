import java.util.PriorityQueue;

class Node4 {
    int val;
    Node4 next;

    Node4(int val) {
        this.val = val;
    }
}

public class merge_k_sorted_list {
        public static Node4 mergeKLists(Node4[] lists) {
            if (lists == null || lists.length == 0) return null;

            PriorityQueue<Node4> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
            for (Node4 node : lists) {
                if (node != null) minHeap.add(node);
            }

            Node4 dummy = new Node4(0);
            Node4 current = dummy;

            while (!minHeap.isEmpty()) {
                Node4 minNode = minHeap.poll();
                current.next = minNode;
                current = current.next;

                if (minNode.next != null) {
                    minHeap.add(minNode.next);
                }
            }

            return dummy.next;
        }

        public static void printList(Node4 head) {
            while (head != null) {
                System.out.print(head.val + " ");
                head = head.next;
            }
            System.out.println();
        }

        public static void main(String[] args) {
            // Example: lists = [[1->4->5],[1->3->4],[2->6]]
            Node4 l1 = new Node4(1);
            l1.next = new Node4(4);
            l1.next.next = new Node4(5);

            Node4 l2 = new Node4(1);
            l2.next = new Node4(3);
            l2.next.next = new Node4(4);

            Node4 l3 = new Node4(2);
            l3.next = new Node4(6);

            Node4[] lists = new Node4[]{l1, l2, l3};

            Node4 merged = mergeKLists(lists);
            printList(merged); // Output: 1 1 2 3 4 4 5 6
        }
}
