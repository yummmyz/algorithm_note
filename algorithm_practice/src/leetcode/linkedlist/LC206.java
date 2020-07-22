package leetcode.linkedlist;

/**
 * Reverse Linked List（反转链表）
 */
public class LC206 {

    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node node = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        Node head = node;
        printListNode(head);
        System.out.println("--------------");
        Node result = reverse(node);
        printListNode(result);
    }

    private static Node reverse(Node head) {
        if (head == null) return null;
        /**
         * 这里的细节重点是要把第二个节点设置成current
         * 然后从第二个节点开始翻转
         */
        Node pre = head;
        Node curr = head.next;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        //最后将原链表的头节点的指针域置为null，还回新链表的头结点，即原链表的尾结点
        head.next = null;
        return pre;
    }

    private static void printListNode(Node node) {
        for (Node curr = node; curr != null; curr = curr.next) {
            System.out.println(curr.data);
        }
    }

}
