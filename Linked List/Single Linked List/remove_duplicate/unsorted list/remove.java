
/*Write a removeDuplicates() function which takes a list and deletes any duplicate nodes from the list. The list is not sorted. 
For example if the linked list is 12->11->12->21->41->43->21 then removeDuplicates() should convert the list to 12->11->21->41->43. 
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

    void remov(Node ref) {
        HashSet<Integer> set = new HashSet<>();
        Node previous = null;
        while (ref != null) {
            if (set.contains(ref.data)) {
                previous.next = ref.next;
            } else {
                set.add(ref.data);
                previous = ref;
            }
            ref = ref.next;
        }
    }

    public static void main(String[] args) {
        Link list = new Link();

        list.push(new Node(1));
        list.push(new Node(5));
        list.push(new Node(5));
        list.push(new Node(3));
        list.push(new Node(12));
        list.push(new Node(1));
        list.push(new Node(2));
        list.push(new Node(9));

        list.display(list.head);

        list.remov(list.head);

        list.display(list.head);
    }
}