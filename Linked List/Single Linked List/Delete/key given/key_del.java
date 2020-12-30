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

    void add_first(Node new_node) {
        new_node.next = head;
        head = new_node;
    }

    void delKey(int key) {
        Node temp = head;
        Node p = null;

        if (temp != null && temp.data == key) {
            head = temp.next;
            return;
        }

        while (temp != null && temp.data != key) {
            p = temp;
            temp = temp.next;
        }

        if (temp == null)
            return;

        p.next = temp.next;
    }

    void display(Node ref) {
        while (ref != null) {
            System.out.print(ref.data + "-->");
            ref = ref.next;
        }
    }

    public static void main(String args[]) {
        Linked l1 = new Linked();

        l1.add_first(new Node(13));
        l1.add_first(new Node(20));
        l1.add_first(new Node(69));
        l1.add_first(new Node(5));

        l1.display(l1.head);

        l1.delKey(69);

        l1.display(l1.head);
    }
}