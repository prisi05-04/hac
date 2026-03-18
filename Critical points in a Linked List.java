/*
Node is defined as:
class Node{
    int val;
    Node next;
    Node(int x){
        val = x; next = null;
    }
}
*/

class Solution {
    static int solve(Node head) {
      
        if (head == null || head.next == null || head.next.next == null) {
            return 0;
        }

        int crit = 0;
        Node previous = head;
        Node current = head.next;
        Node next = head.next.next;

        while (next != null) {
          
            if ((current.val > previous.val && current.val > next.val) ||
                (current.val < previous.val && current.val < next.val)) {
                crit++;
            }

          
            previous = current;
            current = next;
            next = next.next;
        }

        return crit;
    }
}