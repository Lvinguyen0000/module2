package part1.arrayStack;

public class MyArrayStack {
    private int[] arrayStack;
    private int size;
    private int index = 0;

    public MyArrayStack(int size) {
        this.arrayStack = new int[size];
        this.size = size;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return index == 0;
    }

    public boolean isFull(){
        return index == arrayStack.length;
    }

    public void push(int element){
        if(isFull()){
            System.out.println("Stack is full");
            return;
        }
        arrayStack[index++] = element;
    }

    public int pop(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return 0;
        }
        return arrayStack[index--];
    }
}
