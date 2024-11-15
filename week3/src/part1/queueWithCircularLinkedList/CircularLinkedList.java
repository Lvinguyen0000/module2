package part1.queueWithCircularLinkedList;

public class CircularLinkedList {
    private Node head = null;
    private Node tail = null;

    public CircularLinkedList() {}

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        }
        else {
            tail.next = newNode;
        }
        tail = newNode;
        tail.next = head;
    }

    public Node removeFirst(){
        if (head == null) {
            return null;
        }
        tail.next = head.next;
        head = head.next;
        return head;
    }
}

