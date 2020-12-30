class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}

class Link1 {
    Node head;

    public void add_last(Node new_node) {
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

    public void disp(Node ref) {
        while (ref != null) {
            System.out.print(ref.data + "-->");
            ref = ref.next;
        }
    }

    public static void main(String args[]) {
        Link1 llist = new Link1();

        llist.add_last(new Node(23));
        llist.add_last(new Node(12));
        llist.add_last(new Node(26));
        llist.add_last(new Node(69));
        llist.add_last(new Node(45));
        llist.add_last(new Node(28));
        llist.add_last(new Node(90));

        llist.disp(llist.head);
    }
}