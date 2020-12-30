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
        while (temp.next != null)
            temp = temp.next;

        temp.next = new_node;
    }

    void display(Node ref) {
        while (ref != null) {
            System.out.print(ref.data + "-->");
            ref = ref.next;
        }
        System.out.println("null");
    }

    void remove(Node temp) {
        Node fast = head, slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast)
                break;
        }

        if (slow != fast)
            return;
        slow = fast;
        while (slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = null;
    }

    public static void main(String[] args) {
        Link list = new Link();

        list.push(new Node(1));
        list.push(new Node(2));
        list.push(new Node(3));
        list.push(new Node(4));

        list.head.next.next.next.next = list.head.next;

        list.remove(list.head);
        list.display(list.head);
    }
}