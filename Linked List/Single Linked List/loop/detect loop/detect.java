/*Given a linked list, check if the linked list has loop or not. Below diagram shows a linked list with a loop. */

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

    void detect_loop() {
        Node fast = head;
        Node slow = head;
        int flag = 0;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                flag = 1;
                break;
            }
        }
        if (flag == 1)
            System.out.println("loop detected");
        else
            System.out.println("no loop");
    }

    public static void main(String[] args) {
        Link list = new Link();

        list.push(new Node(1));
        list.push(new Node(2));
        list.push(new Node(3));
        list.push(new Node(4));
        list.push(new Node(5));
        list.push(new Node(6));
        list.push(new Node(7));
        list.push(new Node(8));
        list.push(new Node(9));
        list.push(new Node(10));

        list.display(list.head);

        /* Create loop for testing */
        list.head.next.next.next.next = list.head;

        list.detect_loop();
    }
}