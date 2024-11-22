package part1.designPattern.memoryPool;

import java.util.LinkedList;

public abstract class MemoryPool<T> {
    private LinkedList<T> freeItems = new LinkedList<>();

    public void freeItem(T item){
        freeItems.add(item);
    }

    protected abstract T allocate();

    public T newItem(){
        T out = null;
        if (freeItems.isEmpty()){
            out  = allocate();
        }
        else {
            out = freeItems.getFirst();
            freeItems.removeFirst();
        }
        return out;
    }
}
