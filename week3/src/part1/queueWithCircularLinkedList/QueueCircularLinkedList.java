package part1.queueWithCircularLinkedList;

public class QueueCircularLinkedList {
    private CircularLinkedList queue;

    public QueueCircularLinkedList() {
        queue = new CircularLinkedList();
    }

    public void enqueue(int value) {
        queue.addLast(value);
    }

    public int dequeue() {
        return queue.removeFirst().getData();
    }
}
