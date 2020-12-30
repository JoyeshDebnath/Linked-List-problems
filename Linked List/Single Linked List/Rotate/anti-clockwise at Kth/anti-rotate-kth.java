/*
Rotate a Linked List

Given a singly linked list, rotate the linked list counter-clockwise by k nodes. Where k is a given positive integer. For example, if the given linked list is 10->20->30->40->50->60 and k is 4, the list should be modified to 50->60->10->20->30->40. Assume that k is smaller than the count of nodes in linked list.
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

    void push(Node new_node) {
        if (head == null) {
            head = new_node;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
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

    void func(int k) {
        if (k == 0)
            return;
        Node temp = head;
        int count = 1;
        while (count < k && temp.next != null) {
            count += 1;
            temp = temp.next;
        }

        Node end = temp;
        Node new_start = temp.next;

        while (temp.next != null)
            temp = temp.next;

        end.next = null;
        temp.next = head;
        head = new_start;
    }

    public static void main(String[] args) {
        Link list = new Link();

        list.push(new Node(1));
        list.push(new Node(2));
        list.push(new Node(3));
        list.push(new Node(4));
        list.push(new Node(5));
        list.push(new Node(6));

        list.display(list.head);

        list.func(4);

        list.display(list.head);
    }
}