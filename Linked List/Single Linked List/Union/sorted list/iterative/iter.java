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

    Node union(Node node1, Node node2) {
        Node dummy = new Node(-1);
        Node res = dummy;

        if (node1 == null && node2 == null)
            return null;

        while (node1 != null && node2 != null) {
            if (node1.data < node2.data) {
                dummy.next = node1;
                node1 = node1.next;
            } else if (node1.data > node2.data) {
                dummy.next = node2;
                node2 = node2.next;
            } else {
                dummy.next = node2;
                node1 = node1.next;
                node2 = node2.next;
            }
            dummy = dummy.next;
        }

        Node temp = (node1 != null) ? node1 : node2;
        while (temp.next != null) {
            dummy.next = temp;
            temp = temp.next;
        }
        return res.next;
    }

    public static void main(String[] args) {
        Link list1 = new Link();
        Link list2 = new Link();

        list1.push(new Node(1));
        list1.push(new Node(2));
        list1.push(new Node(3));
        list1.push(new Node(4));
        list1.push(new Node(5));

        list1.display(list1.head);

        list2.push(new Node(0));
        list2.push(new Node(1));
        list2.push(new Node(3));
        list2.push(new Node(6));
        list2.push(new Node(7));

        list2.display(list2.head);

        Node un = list1.union(list1.head, list2.head);
        list1.display(un);
    }
}