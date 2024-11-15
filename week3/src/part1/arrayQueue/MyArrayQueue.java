package part1.arrayQueue;

public class MyArrayQueue {
    private int capacity;
    private int[] queueArr;
    private int front;
    private int rear;
    private int currentSize;

    public MyArrayQueue(int queueSize){
        this.capacity = queueSize;
        this.queueArr = new int[queueSize];
    }

    public boolean isQueueEmpty(){
        return currentSize == 0;
    }

    public boolean isQueueFull(){
        return currentSize == capacity;
    }

    public void enqueue(int element){
        if(isQueueFull()){
            System.out.println("Queue is full");
            return;
        }
        currentSize++;
        queueArr[currentSize-1] = element;
        front = queueArr[0];
        rear = queueArr[currentSize-1];
    }

    public int dequeue(){
        if(currentSize == 0){
            System.out.println("Queue is empty");
            return -1;
        }
        int element = queueArr[0];
        pushUp();
        front = queueArr[0];
        rear = queueArr[currentSize-1];
        currentSize--;
        return element;
    }

    private void pushUp(){
        for (int i = 0; i < currentSize; i++) {
            if (i + 1 >= capacity){
                queueArr[i] = 0;
                continue;
            }
            queueArr[i] = queueArr[i + 1];
        }
    }
}
