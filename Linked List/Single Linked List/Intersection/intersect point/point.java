
/*
Write a function to get the intersection point of two Linked Lists

There are two singly linked lists in a system. By some programming error, the end node of one of the linked list got linked to the second list, forming an inverted Y shaped list. Write a program to get the point where two linked list merge.
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

    void point(Node head1, Node head2) {

        HashSet<Integer> set = new HashSet<>();

        while (head1 != null) {
            set.add(head1.data);
            head1 = head1.next;
        }

        while (head2 != null) {
            if (set.contains(head2.data)) {
                System.out.println(head2.data);
                break;
            }
            head2 = head2.next;
        }
    }

    public static void main(String[] args) {
        Link list1 = new Link();
        Link list2 = new Link();

        list1.push(new Node(1));
        list1.push(new Node(2));
        list1.push(new Node(3));
        list1.push(new Node(4));
        list1.push(new Node(5));
        list1.push(new Node(6));

        list1.display(list1.head);

        list2.push(new Node(0));
        list2.push(new Node(7));
        list2.push(new Node(3));
        list2.push(new Node(4));

        list2.display(list2.head);

        list1.point(list1.head, list2.head);
    }
}