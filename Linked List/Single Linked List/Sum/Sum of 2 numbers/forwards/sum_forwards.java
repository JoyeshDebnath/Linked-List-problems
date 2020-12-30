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

    void push(Node node) {
        if (head == null) {
            head = node;
            return;
        }

        Node temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = node;
    }

    void display(Node ref) {
        while (ref != null) {
            System.out.print(ref.data + "-->");
            ref = ref.next;
        }
        System.out.println("null");
    }

    // Reversing Linked List
    Node rev(Node temp) {
        if (temp == null || temp.next == null)
            return temp;
        Node rest = rev(temp.next);
        temp.next.next = temp;
        temp.next = null;

        return rest;
    }

    // Adding 2 Nodes
    Node sum(Node l1, Node l2) {
        Node dummy = new Node(0);
        Node l3 = dummy;
        int sum = 0;
        int carry = 0;
        int last = 0;

        while (l1 != null || l2 != null) {
            sum = carry + ((l1 != null) ? l1.data : 0) + ((l2 != null) ? l2.data : 0);
            carry = sum / 10;
            last = sum % 10;

            Node node = new Node(last);
            l3.next = node;

            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;

            l3 = l3.next;
        }

        if (carry > 0) {
            Node node = new Node(1);
            l3.next = node;
            l3 = l3.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Link list1 = new Link();
        Link list2 = new Link();

        // Linked List 1
        list1.push(new Node(1));
        list1.push(new Node(1));
        list1.push(new Node(1));

        list1.display(list1.head);

        // Linked List 2
        list2.push(new Node(1));
        list2.push(new Node(1));

        list2.display(list2.head);

        Node l1 = list1.rev(list1.head);
        Node l2 = list1.rev(list2.head);

        // Sum of 2 Linked List(forward)
        Node l3 = list1.sum(l1, l2);
        list1.display(list1.rev(l3));
    }
}