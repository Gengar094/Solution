public class MyLinkedList{

    private ListNode head;

    private class ListNode {

        private int val;
        private ListNode next;

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        ListNode (int val) {
            new ListNode(val, null);
        }
    }


    public int get (int index) {
        if (!validIndex(index)) {
            return -1;
        }

        ListNode curr = head;
        for (int i = 0; i < index ; i++) {
            curr = curr.next;
        }
        return curr.val;
    }

    public int length() {
        int i = 0;
        ListNode curr = head;
        while (curr != null) {
            i++;
            curr = curr.next;
        }
        return i;
    }


    public void addAtHead (int val) {
        if (head == null) {
            head = new ListNode(val);
        } else {
            ListNode node = new ListNode(val);
            node.next = head;
            head = node;
        }
    }


    public void addAtTail (int val) {
        ListNode curr = head;
        if (head == null) {
            head = new ListNode(val);
        } else {
            for (int i = 0; i < length(); i++) {
                curr = curr.next;
            }
            cur.next = new ListNode(val);
        }
    }

    public void addAtIndex (int index, int val) {
        if (!validIndex(index)) {
            return;
        }

        ListNode node = new ListNode(val);
        ListNode prev = head;

        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }
        node.next = prev.next;
        prev.next = node;
    }


    public void deleteAtIndex (int index) {
        if (validIndex(index)) {
            return;
        }

        ListNode prev = head;
        if (index == 0) {
            deleteAtHead();
        } else if (index == length() - 1) {
            deleteAtTail();
        } else {
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            prev.next = prev.next.next;
        }
    }

    private void deleteAtTail() {
        ListNode prev = head;
        for (int i = 0; i < length() - 1; i++) {
            prev = prev.next;
        }
        prev.next = null;

    }

    private void deleteAtHead() {
        head = head.next;
    }

    public boolean validIndex (int index) {
        if (index >= length() || index < 0) {
            return false;
        }
        return true;
    }


} 