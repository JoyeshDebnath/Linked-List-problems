/*
Write a function detectAndCountLoop() that checks whether a given Linked List contains loop and if loop is present then returns count of nodes in loop. For example, the loop is present in below-linked list and length of the loop is 4. If the loop is not present, then the function should return 0.
*/

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

    void detectAndCountLoop() {
        Node fast = head;
        Node slow = head;
        Node temp;
        int flag = 0;
        int length = 1;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                flag = 1;
                break;
            }
        }

        if (flag == 1) {
            System.out.println("loop detected");
            temp = slow;
            while (temp.next != slow) {
                temp = temp.next;
                length = length + 1;
            }
            System.out.println("loop size:" + length);
        } else {
            System.out.println("no loop present");
        }
    }

    public static void main(String[] args) {
        Link list = new Link();

        list.push(new Node(1));
        list.push(new Node(2));
        list.push(new Node(3));
        list.push(new Node(4));
        list.push(new Node(5));
        // list.push(new Node(6));
        // list.push(new Node(7));
        // list.push(new Node(8));
        // list.push(new Node(9));
        // list.push(new Node(10));
        // list.push(new Node(11));

        list.display(list.head);

        list.head.next.next.next.next.next = list.head.next;

        list.detectAndCountLoop();
    }
}