/*
CLone a single linked list and also its random addresses using Hashing
*/

import java.util.HashMap;

class Node {
    int data;
    Node next;
    Node random;

    Node(int data) {
        this.data = data;
        next = random = null;
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
        while (temp.next != null)
            temp = temp.next;

        temp.next = new_node;
    }

    void display(Node ref) {
        while (ref != null) {
            System.out.println("Data:" + ref.data + "\t" + "Random:" + ref.random.data);
            ref = ref.next;
        }
        System.out.println();
    }

    Node clone(Node list1) {
        HashMap<Node, Node> map = new HashMap<>();

        for (Node current = head; current != null; current = current.next)
            map.put(current, new Node(current.data));

        for (Node current = head; current != null; current = current.next) {
            Node cloneCurr = map.get(current);
            cloneCurr.next = map.get(current.next);
            cloneCurr.random = map.get(current.random);
        }

        Node list2 = map.get(list1);
        return list2;
    }

    public static void main(String[] args) {
        Link list = new Link();

        list.push(new Node(10));
        list.push(new Node(5));
        list.push(new Node(20));
        list.push(new Node(15));
        list.push(new Node(20));

        list.head.random = list.head.next.next;
        list.head.next.random = list.head.next.next.next;
        list.head.next.next.random = list.head;
        list.head.next.next.next.random = list.head.next.next;
        list.head.next.next.next.next.random = list.head.next.next.next;

        System.out.println("Before Cloning");
        list.display(list.head);

        System.out.println("After Cloning");
        list.display(list.clone(list.head));
    }
}