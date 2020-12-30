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

    // middle of linked list
    Node middle(Node ref) {
        Node slow = ref;
        Node fast = ref;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    // merges two Linked List recursively
    Node merge(Node l1, Node l2) {
        Node res = null;

        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        if (l1.data <= l2.data) {
            res = l1;
            res.next = merge(l1.next, l2);
        } else {
            res = l2;
            res.next = merge(l1, l2.next);
        }

        return res;
    }

    // Merge Sort
    Node mergeSort(Node l) {
        if (l == null || l.next == null)
            return l;

        Node mid = middle(l);
        Node nextofmiddle = mid.next;
        mid.next = null;

        Node left = mergeSort(l);
        Node right = mergeSort(nextofmiddle);

        Node res = merge(left, right);
        return res;
    }

    public static void main(String[] args) {
        Link list = new Link();

        list.push(new Node(5));
        list.push(new Node(2));
        list.push(new Node(4));
        list.push(new Node(1));
        list.push(new Node(3));

        list.display(list.head);

        Node sort = list.mergeSort(list.head);
        list.display(sort);
    }
}