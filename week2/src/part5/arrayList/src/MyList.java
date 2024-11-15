import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList(){
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity){
        elements = new Object[capacity];
    }

    private void ensureCapacity(){
        int newSize = elements.length + 1;
        elements = Arrays.copyOf(elements, newSize);
    }

    public void add (int index, E element){
        if (index < 0 || index > size) return;
        ensureCapacity();
        Object temp = elements[index];
        elements[index] = element;
        for (int i = index; i < size; i++){
            Object temp2 = elements[i+1];
            elements[i+1] = temp;
            temp = temp2;
        }
    }

    public E remove(int index){
        if (index < 0 || index > size) return null;
        Object temp = elements[index];
        for (int i = index; i < size; i++){
            Object temp2 = elements[i];
            elements[i] = elements[i+1];
            elements[i+1] = temp2;
        }
        size--;
        return (E) temp;
    }

    public int size(){
        return size;
    }

    public E clone(){
        return (E) Arrays.copyOf(elements, size);
    }

    public boolean contains(E element){
        for (int i = 0; i < size; i++){
            if (elements[i].equals(element)) return true;
        }
        return false;
    }

    public int indexOf(E element){
        for (int i = 0; i < size; i++){
            if (elements[i].equals(element)) return i;
        }
        return -1;
    }

    public boolean add(E element){
        add(size, element);
        return true;
    }

    public E get(int index){
        if (index < 0 || index > size) return null;
        return (E) elements[index];
    }

    public void clear(){
        elements = new Object[DEFAULT_CAPACITY];
        size = DEFAULT_CAPACITY;
    }
}
