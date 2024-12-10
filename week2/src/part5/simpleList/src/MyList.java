package part5.simpleList.src;

import java.lang.annotation.ElementType;
import java.util.Arrays;


public class MyList<E> {
    private int size = 0;
    private final int DEFAULT_CAPACITY = 10;
    private Object elenment[];

    public MyList(){
        elenment = new Object[DEFAULT_CAPACITY];
    }

    private void ensureCapacity(){
        int newSize = elenment.length * 2;
        elenment = Arrays.copyOf(elenment, newSize);
    }

    public void add (E e){
        if (size == elenment.length){
            ensureCapacity();
        }
        elenment[size++] = e;
    }

    public E get(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (E) elenment[index];
    }
}
