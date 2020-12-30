/*
CLone a single linked list and also its random addresses without using Hashing.....it should be an efficient technique
*/

class Node {
    int data;
    Node next;
    Node random;

    Node(int data) {
        this.data = data;
        next = random = null;
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
            System.out.println("Data:" + ref.data + "\t" + "Random:" + ref.random.data);
            ref = ref.next;
        }
        System.out.println();
    }

    Node clone(Node list1) {
        Node temp = list1;
        Node after;

        while (temp != null) {
            after = temp.next;
            temp.next = new Node(temp.data);
            temp.next.next = after;
            temp = temp.next;
            temp = after;
        }

        temp = list1;
        while (temp != null) {
            if (temp.random != null)
                temp.next.random = temp.random.next;
            else
                temp.next.random = null;

            temp = temp.next.next;
        }

        Node original = list1;
        Node copy = list1.next;
        Node res = copy;

        while (original != null && copy != null) {
            original.next = original.next != null ? original.next.next : original.next;

            copy.next = copy.next != null ? copy.next.next : copy.next;
            original = original.next;
            copy = copy.next;
        }
        return res;
    }

    public static void main(String[] args) {
        Link list = new Link();

        list.push(new Node(10));
        list.push(new Node(5));
        list.push(new Node(20));
        list.push(new Node(15));
        list.push(new Node(20));

        list.head.random = list.head.next.next;
        list.head.next.random = list.head.next.next.next;
        list.head.next.next.random = list.head;
        list.head.next.next.next.random = list.head.next.next;
        list.head.next.next.next.next.random = list.head.next.next.next;

        System.out.println("Before Cloning");
        list.display(list.head);

        System.out.println("After Cloning");
        list.display(list.clone(list.head));
    }
}
