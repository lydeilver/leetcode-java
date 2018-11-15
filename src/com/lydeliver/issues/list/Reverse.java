package com.lydeliver.issues.list;

/**
 * @ClassName Reverse
 * @Author jonathan
 * @Date 2018/11/8 5:40 PM
 * @Version 1.0
 * @Description TODO
 */
public class Reverse {

    Node reverseUtil(Node head) {

        if (head == null || head.next == null) return head;
        Node p = reverseUtil(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }


    public static void main(String[] args) {
        Node node = new Node(1);
/*        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);*/
        Reverse s = new Reverse();
        s.reverseUtil(node);
    }
}

class Node {
    int i;
    Node next;

    public Node(int i) {
        this.i = i;
    }
}
