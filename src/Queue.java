public class Queue<T> {

    private T[] array;
    private int f;
    private int r;
    private int size;

    public Queue(int size){
        this.array = (T[]) new Object[size];
        this.f = 0;
        this.r = 0;
        this.size = size+1;
    }

    public void enqueue(T data){
        if (!(size() == size-1)) {
            array[r] = data;
            r = (r + 1) % size;
        }
    }
    public T dequeue(){
        if (f != r) {
            T data = array[f];
            array[f] = null;
            f = (f + 1) % size;
            return data;
        }
        return null;
    }

    public void print(){
        for (int i = f; i < r; i++){
            System.out.println(array[i]);
        }
    }

    public int size(){
        return ((size-f)+r)%size;
    }
    public boolean isEmpty(){
        if (f == r){
            return true;
        }
        return false;
    }

    public T front(){
        if (f != r){
            return array[f];
        }
        return null;
    }
    public void pointer(){
        System.out.println("Front pointer at index: " + f
                + "\nRear pointer at index: " + r);
    }

}
