
public class StackArray<T> {
    private T[] array;
    int position;

    public StackArray(int size){
        this.array = (T[]) new Object[size];
        this.position = -1;
    }

    public void push(T value){
        if (position < array.length){
            position++;
            array[position] = value;
        }
    }
    public T pop(){
        if (position >= 0){
            position--;
            return array[position+1];
        }
        return null;
    }
    public int size(){
        return position+1;
    }

    public boolean isEmpty() {
        if (position < 0)
            return true;
        return false;
    }
}
