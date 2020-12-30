class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}

class Linked {
    Node head;

    void add_front(Node new_node) {
        new_node.next = head;
        head = new_node;
    }

    void add_end(Node new_node) {
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

    void add_specific(Node prev_node, Node new_node) {

        if (prev_node == null) {
            System.out.println("Previous node cannot be null!");
            return;
        }
        new_node.next = prev_node.next;
        prev_node.next = new_node;
    }

    public void disp(Node ref) {
        while (ref != null) {
            System.out.print(ref.data + "-->");
            ref = ref.next;
        }
    }

    public static void main(String[] args) {
        Linked l1 = new Linked();

        l1.add_front(new Node(12));
        l1.add_front(new Node(9));

        l1.add_end(new Node(23));
        l1.add_end(new Node(5));
        l1.add_end(new Node(69));

        l1.add_specific(l1.head.next, new Node(55));

        l1.disp(l1.head);
    }
}