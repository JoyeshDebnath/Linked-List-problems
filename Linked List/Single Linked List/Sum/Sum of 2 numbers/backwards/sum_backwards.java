
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

    Node add(Node head1, Node head2) {
        Node dummy = new Node(0);
        Node head3 = dummy;
        int sum = 0;
        int carry = 0;
        int last = 0;

        while (head1 != null || head2 != null) {
            sum = carry + ((head1 != null) ? head1.data : 0) + ((head2 != null) ? head2.data : 0);
            carry = sum / 10;
            last = sum % 10;

            Node node = new Node(last);
            head3.next = node;

            if (head1 != null)
                head1 = head1.next;
            if (head2 != null)
                head2 = head2.next;

            head3 = head3.next;
        }

        if (carry > 0) {
            Node node = new Node(1);
            head3.next = node;
            head3 = head3.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Link list1 = new Link();
        Link list2 = new Link();

        list1.push(new Node(5));
        list1.push(new Node(6));
        list1.push(new Node(3));
        // list1.push(new Node(4));
        // list1.push(new Node(5));

        list1.display(list1.head);

        list2.push(new Node(8));
        list2.push(new Node(4));
        list2.push(new Node(2));
        // list2.push(new Node(2));
        // list2.push(new Node(1));

        list2.display(list2.head);

        Node accept = list1.add(list1.head, list2.head);
        list1.display(accept);
    }
}