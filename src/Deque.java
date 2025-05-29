public class Deque<T> {

    private T[] array;
    private int f;
    private int r;
    private int size;

    public Deque(int size){
        this.array = (T[]) new Object[size];
        this.f = 0;
        this.r = 0;
        this.size = size;
    }

    public void addLast(T data){
        if (!(size() == size-1)) {
            array[r] = data;
            r = (r + 1) % size;
        }
    }

    public void addFirst(T data){
        if (!(size() == size-1)) {
            f = (f-1+size) % size;
            array[f] = data;
        }
    }

    public T removeFirst(){
        if (f != r ) {
            T data = array[f];
            array[f] = null;
            f = (f + 1) % size;
            return data;
        }
        return null;
    }

    public T removeLast(){
        if (f != r){
            r = (r - 1 + size)%size;
            T data = array[r];
            array[r] = null;
            return data;
        }
        return null;
    }




    public void print(){
        int a = f;
        int b = r;

        while (a != b){
            System.out.println(array[a]);
            a = (a+1)%size;
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
