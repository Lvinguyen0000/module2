public class MyLinkedList<E> {
    private class Node{
        Node next;
        Object data;
        Node(Object data){
            this.data = data;
            this.next = null;
        }
        Object getData(){
            return this.data;
        }
    }
    private Node head;
    private int numNodes;

    public MyLinkedList(){
        head = null;
    }

    public void add(int index, E e){
        if (index < 0 || index > numNodes) return;
        int tempIndex = 0;
        Node temp = head;
        while(temp != null){
            if(tempIndex == index){
                Node newNode = new Node(e);
                newNode.next = temp;
                numNodes++;
                return;
            }
            temp = temp.next;
            tempIndex++;
        }
    }

    public void addFirst(E e){
        add (0, e);
    }

    public void addLast(E e){
        add (numNodes, e);
    }

    public E remove(int index){
        if (index < 0 || index > numNodes) return null;
        if (index == 0){
            Node temp = head;
            head = head.next;
            numNodes--;
            return (E)temp.data;
        }
        Node temp = head;
        Node nextTemp = temp.next;
        int tempIndex = 0;
        while(temp.next != null){
            if (tempIndex == index){
                temp.next = nextTemp.next;
                numNodes--;
                return (E) nextTemp;
            }
            temp = temp.next;
            nextTemp = nextTemp.next;
            tempIndex++;
        }
        return null;
    }

    public boolean remove(E e){
        if (numNodes == 0) return false;
        if (head == e){
            head = head.next;
            numNodes--;
            return true;
        }
        Node temp = head;
        Node nextTemp = temp.next;
        while(temp.next != null){
            if (temp == e){
                temp.next = nextTemp.next;
                numNodes--;
                return true;
            }
            temp = temp.next;
            nextTemp = nextTemp.next;
        }
        return false;
    }

    public int size(){
        return numNodes;
    }

    public E clone(){
        return (E)head;
    }

    public boolean contains(E e){
        if (numNodes == 0) return false;
        Node temp = head;
        while(temp != null){
            if (temp.data.equals(e)) return true;
            temp = temp.next;
        }
        return false;
    }

    public int indexOf(E e){
        if (numNodes == 0) return -1;
        Node temp = head;
        int tempIndex = 0;
        while(temp != null){
            if (temp == e) return tempIndex;
            temp = temp.next;
            tempIndex++;
        }
        return -1;
    }

    public boolean add(E e){
        addLast(e);
        return true;
    }

    private void ensureCapacity(int minCapacity){
        if (minCapacity > numNodes) return;
    }

    public E get(int index){
        if (index < 0 || index > numNodes) return null;
        Node temp = head;
        int tempIndex = 0;
        do{
            if(tempIndex == index){
                return (E)temp;
            }
            temp = temp.next;
        }
        while(temp != null);
        return null;
    }

    public E getFirst(){
        return get(0);
    }

    public E getLast(){
        return get(numNodes-1);
    }

    public void clear(){
        head = null;
        numNodes = 0;
    }
}
