public class Queue {
    private Node head;
    private Node tail;

    public Queue() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void enqueue(char value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public char dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Очередь пуста!");
        }
        char value = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return value;
    }
}