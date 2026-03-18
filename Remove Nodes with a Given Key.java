static Node removeKey(Node head, int key) {
        while (head != null && head.data == key)
            head = head.next;

        if (head == null) return null;

        Node curr = head;
        while (curr.next != null) {
            if (curr.next.data == key)
                curr.next = curr.next.next;
            else
                curr = curr.next;
        }

        return head;
    }

   
    