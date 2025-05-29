public class StackLinkedList<T>{

    private DoublyLinkedList<T> list;

    public StackLinkedList(){
        list = new DoublyLinkedList<T>();
    }
    public void push(T value){
        list.addToStart(value);
    }

    public T pop(){
        if (list.size() > 0) {
            T value = list.get(1);
            list.removeFirst();
            return value;
        }
        return null;
    }

    public int size(){
        return list.size();
    }


}
