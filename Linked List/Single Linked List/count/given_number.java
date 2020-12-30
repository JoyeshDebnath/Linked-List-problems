// Given a singly linked list and a key, count number of occurrences of given key in linked list. For example, if given linked list is 1->2->1->2->1->3->1 and given key is 1, then output should be 4

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
        System.out.print("null\n");
    }

    void count(Node ref, int key) {
        int count = 0;
        while (ref != null) {
            if (ref.data == key)
                count = count + 1;
            ref = ref.next;
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        Link list = new Link();

        list.push(new Node(1));
        list.push(new Node(1));
        list.push(new Node(1));
        list.push(new Node(1));
        list.push(new Node(1));

        list.display(list.head);

        list.count(list.head, 1);
    }
}