package part1.queueWithLinkedList;

public class MyLinkedListQueue {
    private Node head;
    private Node tail;

    public MyLinkedListQueue() {
        this.head = null;
        this.tail = null;
    }

    public void enqueue(int key) {
        Node newNode = new Node(key);
        if (this.tail == null){
            this.head = this.tail = newNode;
            return;
        }
        this.tail.next = newNode;
        this.tail = newNode;
    }

    public Node dequeue(){
        if (this.head == null){
            return null;
        }
        Node temp = this.head;
        this.head = this.head.next;
        if (this.head == null){
            this.tail = null;
        }
        return temp;
    }
}
