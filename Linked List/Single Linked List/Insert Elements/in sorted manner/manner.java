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

    void order(Node key) {
        Node temp = head;
        Node after = null;
        if (key.data < head.data) {
            key.next = head;
            head = key;
        }

        while (temp.next != null) {
            if (key.data >= temp.data && key.data < temp.next.data) {
                after = temp.next;
                temp.next = key;
                key.next = after;
            }
            temp = temp.next;
        }

        if (key.data > temp.data) {
            temp.next = key;
            key.next = null;
        }
    }

    public static void main(String[] args) {
        Link list = new Link();

        list.push(new Node(1));
        list.push(new Node(2));
        list.push(new Node(4));
        list.push(new Node(5));

        list.display(list.head);

        list.order(new Node(3));

        list.display(list.head);
    }
}