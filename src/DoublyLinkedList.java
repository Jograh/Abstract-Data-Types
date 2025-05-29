public class DoublyLinkedList<T> {

    private Node head;
    private Node tail;

    private class Node {

        T data;
        Node next;
        Node previous;

        public Node(T data, Node previous, Node next ){
            this.data = data;
            this.previous = previous;
            this.next = next;
        }
    }

    //constructor
    public DoublyLinkedList(){
        this.head = new Node(null,null, tail);
        this.tail = new Node(null, head, null);
        head.next = tail;
    }

    //
    public void addToStart(T data){

        Node newNode = new Node(data, head, head.next);
        head.next.previous = newNode;
        head.next = newNode;
    }

    public void addToEnd(T data){
      Node newNode = new Node(data, tail.previous, tail);
      tail.previous.next = newNode;
      tail.previous = newNode;
    }

    public void read(){
        Node current = head.next;
        int counter = 1;
        while (current.next != null){
            System.out.println("Node " + counter + " Data: " + current.data);
            current = current.next;
            counter++;
        }
    }

    public void removeFirst(){
        if (head.next != tail) {
            head.next.next.previous = head;
            head.next = head.next.next;
        }
    }

    public void removeLast(){
        if (tail.previous != head){
            tail.previous.previous.next = tail;
            tail.previous = tail.previous.previous;
        }
    }

    public int size(){
        Node current = head.next;
        int counter = 0;
        while(current.next != null){
            current = current.next;
            counter++;
        }
        return counter;
    }

    public T get(int index){
        Node current = head.next;
        for (int i = 0; i < (index-1); i++){
            current = current.next;
        }
        return current.data;
    }
}
