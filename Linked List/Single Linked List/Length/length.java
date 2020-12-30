import org.graalvm.compiler.graph.Node;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}

class Linked {
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

    void count(Node temp) {
        int c = 0;

        while (temp != null) {
            c = c + 1;
            temp = temp.next;
        }
        System.out.println("Length of linked list = " + c);
    }

    void display(Node ref) {
        while (ref != null) {
            System.out.print(ref.data + "-->");
            ref = ref.next;
        }
        System.out.print("null\n");
    }

    public static void main(String[] args) {
        Linked list = new Linked();

        list.push(new Node(1));
        list.push(new Node(2));
        list.push(new Node(3));
        list.push(new Node(4));
        list.push(new Node(5));

        list.display(list.head);

        list.count(list.head);
    }
}