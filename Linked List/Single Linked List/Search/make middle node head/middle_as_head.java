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

    void mid() {
        Node slow = head;
        Node fast = head;
        Node prev = null;
        // Node after = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        prev.next = prev.next.next;
        slow.next = head;
        head = slow;
    }

    public static void main(String[] args) {
        Link list = new Link();

        list.push(new Node(1));
        list.push(new Node(2));
        list.push(new Node(3));
        list.push(new Node(4));
        list.push(new Node(5));

        list.display(list.head);

        list.mid();

        list.display(list.head);
    }
}