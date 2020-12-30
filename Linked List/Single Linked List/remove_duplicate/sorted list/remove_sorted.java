/*
 * Remove duplicates from a sorted linked list
 * 
 * Write a function which takes a list sorted in non-decreasing order and
 * deletes any duplicate nodes from the list. The list should only be traversed
 * once. For example if the linked list is 11->11->11->21->43->43->60 then
 * removeDuplicates() should convert the list to 11->21->43->60.
 */

import java.util.HashSet;

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

    Node deleteDuplicates(Node head1) {
        Node prev = head1;
        Node temp = head1;

        if (head1 == null || head1.next == null)
            return head1;

        while (temp != null) {
            if (prev.data != temp.data) {
                prev.next = temp;
                prev = temp;
                temp = temp.next;
            } else {
                temp = temp.next;
                prev.next = null;
            }

        }
        return head1;
    }

    public static void main(String[] args) {
        Link list = new Link();

        list.push(new Node(1));
        list.push(new Node(1));
        list.push(new Node(1));
        list.push(new Node(1));
        list.push(new Node(1));
        list.push(new Node(1));
        list.push(new Node(2));
        list.push(new Node(2));
        list.push(new Node(2));
        list.push(new Node(3));
        list.push(new Node(3));
        list.push(new Node(3));
        list.push(new Node(4));

        list.display(list.head);

        list.display(list.deleteDuplicates(list.head));
    }
}