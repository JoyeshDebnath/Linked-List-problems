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

    boolean search(Node ref, int key) {
        while (ref != null) {
            if (ref.data == key)
                return true;
            ref = ref.next;
        }
        return false;
    }

    public static void main(String[] args) {
        Linked list = new Linked();

        list.push(new Node(1));
        list.push(new Node(2));
        list.push(new Node(3));
        list.push(new Node(4));
        list.push(new Node(5));

        list.display(list.head);

        if (list.search(list.head, 2))
            System.out.println("Found");
        else
            System.out.println("Not found");
    }
}