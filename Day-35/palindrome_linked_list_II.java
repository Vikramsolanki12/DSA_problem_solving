public class palindrome_linked_list_II {
        static class ListNode {
            int val;
            ListNode next;
            ListNode(int val) { this.val = val; }
        }

        public static boolean isPalindrome(ListNode head) {
            if (head == null || head.next == null) return true;

            ListNode slow = head, fast = head;
            while (fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }

            ListNode secondHalf = reverse(slow);

            ListNode firstHalf = head;
            while (secondHalf != null){
                if (firstHalf.val != secondHalf.val) return false;
                firstHalf = firstHalf.next;
                secondHalf = secondHalf.next;
            }
            return true;
        }

        private static ListNode reverse(ListNode head){
            ListNode prev = null;
            while (head != null){
                ListNode nextNode = head.next;
                head.next = prev;
                prev = head;
                head = nextNode;
            }
            return prev;
        }

        public static void main(String[] args) {
            ListNode head = new ListNode(1);
            head.next = new ListNode(2);
            head.next.next = new ListNode(2);
            head.next.next.next = new ListNode(1);

            System.out.println(isPalindrome(head));  // Output: true
        }
}
