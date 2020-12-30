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

    public void add(Node new_node) {
        new_node.next = head;
        head = new_node;
    }

    void display(Node ref) {
        while (ref.next != null) {
            System.out.print(ref.data + "-->");
            ref = ref.next;
        }
        if (ref.next == null)
            System.out.print(ref.data);
    }

    public static void main(String[] args) {
        Linked l1 = new Linked();

        l1.add(new Node(10));
        l1.add(new Node(9));
        l1.add(new Node(8));
        l1.add(new Node(7));

        l1.display(l1.head);
    }
}