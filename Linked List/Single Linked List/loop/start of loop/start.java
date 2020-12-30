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

    void loop_start() {
        Node fast = head;
        Node slow = head;
        Node temp;
        int flag = 0;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                flag = 1;
                break;
            }
        }
        if (flag == 1) {
            System.out.println("loop exists");
            temp = slow;
            while (temp.next != slow) {
                temp = temp.next;
            }
            System.out.println("loop start node:" + temp.data);
        } else {
            System.out.println("no loop");
        }
    }

    public static void main(String[] args) {
        Link list = new Link();

        list.push(new Node(1));
        list.push(new Node(2));
        list.push(new Node(3));
        list.push(new Node(4));
        list.push(new Node(5));

        list.display(list.head);

        list.head.next.next.next.next.next = list.head.next;

        list.loop_start();
    }
}