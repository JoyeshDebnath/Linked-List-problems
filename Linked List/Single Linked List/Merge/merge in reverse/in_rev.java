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
        }//hellow world
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

    Node merger(Node head1, Node head2) {
        Node res = null;
        Node after = null;

        if (head1 == null && head2 == null) {
            return null;
        }

        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                after = head1.next;
                head1.next = res;
                res = head1;
                head1 = after;
            } else {
                after = head2.next;
                head2.next = res;
                res = head2;
                head2 = after;
            }
        }
        Node temp = head1 != null ? head1 : head2;
        while (temp != null) {
            after = temp.next;
            temp.next = res;
            res = temp;
            temp = after;
        }
        return res;
    }

    public static void main(String[] args) {
        Link list1 = new Link();
        Link list2 = new Link();

        list1.push(new Node(1));
        // list1.push(new Node(2));
        list1.push(new Node(3));
        // list1.push(new Node(4));
        list1.push(new Node(5));

        list1.display(list1.head);

        // list2.push(new Node(1));
        list2.push(new Node(2));
        // list2.push(new Node(3));
        list2.push(new Node(4));
        // list2.push(new Node(5));

        list2.display(list2.head);

        Node merged = list1.merger(list1.head, list2.head);
        list1.display(merged);
    }
}
