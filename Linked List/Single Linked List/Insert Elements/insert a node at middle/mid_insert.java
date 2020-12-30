/*
Insert node into the middle of the linked list

Given a linked list containing n nodes. The problem is to insert a new node with data x at the middle of the list. If n is even, then insert the new node after the (n/2)th node, else insert the new node after the (n+1)/2th node.

Examples:

Input : list: 1->2->4->5
        x = 3
Output : 1->2->3->4->5

Input : list: 5->10->4->32->16
        x = 41
Output : 5->10->4->41->32->16
*/

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}

class Link {
    Node head;
    int count = 1;

    void push(Node new_node) {
        if (head == null) {
            head = new_node;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            count += 1;
            temp = temp.next;
        }
        temp.next = new_node;
    }

    void display(Node ref) {
        while (ref != null) {
            System.out.print(ref.data + "-->");
            ref = ref.next;
        }
        System.out.println("null");
    }

    void mid(Node val) {
        Node prev = null;
        Node after = null;
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
            after = slow.next;
        }

        if (count % 2 == 0) {
            prev.next = val;
            val.next = slow;
        } else {
            slow.next = val;
            val.next = after;
        }
    }

    public static void main(String[] args) {
        Link list = new Link();

        list.push(new Node(1));
        list.push(new Node(2));
        list.push(new Node(3));
        list.push(new Node(4));
        list.push(new Node(5));

        list.display(list.head);
        list.mid(new Node(69));
        list.display(list.head);
    }
}