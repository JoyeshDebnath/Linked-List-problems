
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
    Node dummy;

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

    Node merge(Node list1, Node list2) {
        if (list1 == null)
            return list2;

        if (list2 == null)
            return list1;

        if (list1.data < list2.data) {
            list1.next = merge(list1.next, list2);
            return list1;
        } else {
            list2.next = merge(list1, list2.next);
            return list2;
        }
    }

    public static void main(String[] args) {
        Link list1 = new Link();
        Link list2 = new Link();

        list1.push(new Node(1));
        list1.push(new Node(2));
        list1.push(new Node(2));
        list1.push(new Node(3));
        list1.push(new Node(4));

        list1.display(list1.head);

        list2.push(new Node(1));
        list2.push(new Node(2));
        list2.push(new Node(5));

        list2.display(list2.head);

        list1.head = list1.merge(list1.head, list2.head);
        list1.display(list1.head);
    }
}