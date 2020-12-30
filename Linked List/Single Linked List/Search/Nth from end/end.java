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

    void find(Node ref, int key) {
        int length = 0;
        while (ref != null) {
            length = length + 1;
            ref = ref.next;
        }

        if (key > length) {
            System.out.println("Not possible");
        }

        int counter = 1;
        int pos = length - key + 1;
        Node temp = head;
        while (temp != null) {
            if (pos == counter) {
                System.out.println("Node data:" + temp.data);
            }
            counter = counter + 1;
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Link list = new Link();

        list.push(new Node(35));
        list.push(new Node(15));
        list.push(new Node(4));
        list.push(new Node(20));

        list.display(list.head);

        list.find(list.head, 4);
    }
}