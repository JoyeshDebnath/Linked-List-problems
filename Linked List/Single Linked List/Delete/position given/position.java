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

    void insert_first(Node new_node) {
        new_node.next = head;
        head = new_node;
    }

    void disp(Node ref) {
        while (ref != null) {
            System.out.print(ref.data + "-->");
            ref = ref.next;
        }
    }

    void delete(int pos) {
        if (head == null)
            return;

        Node temp = head;
        if (pos == 0) {
            head = temp.next;
            return;
        }

        int index = 0;
        while (temp != null && index < pos - 1) {
            temp = temp.next;
            index++;
        }
        if (temp == null || temp.next == null)
            return;

        Node p = temp.next.next;
        temp.next = p;
    }

    void disp(Node ref) {
        while (ref != null) {
            System.out.print(ref.data + "-->");
            ref = ref.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Link link = new Link();

        link.insert_first(new Node(7));
        link.insert_first(new Node(1));
        link.insert_first(new Node(3));
        link.insert_first(new Node(2));
        link.insert_first(new Node(8));

        link.disp(link.head);
        System.out.println();

        link.delete(1);

        link.disp(link.head);
    }
}
