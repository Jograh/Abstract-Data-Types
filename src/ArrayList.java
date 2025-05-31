public class ArrayList<T> {

    private T[] array;
    private int size;

    public ArrayList(int size){
        this.array = (T[]) new Object[size];
        this.size = 0;
    }

    public void add(int i, T data){
       if  (size == this.array.length)
           extendArray();

       //push back every element, size
       for (int j = size; j > i; j--){
            array[j] = array[j-1];
       }

       array[i] = data;
       size++;
    }

    public void add(T data) {
        if (size == this.array.length)
            extendArray();

        array[size] = data;
        size++;
    }

    public T get(int i){
        if (array[i] == null)
            throw (new NullPointerException("index not found"));

        return array[i];
    }

    public T remove(int i){
        if (array[i] == null)
            throw (new NullPointerException("index not found"));

        T temp = array[i];

        //push every element back once
        for (int j = i; j < size; j++){
            array[j] = array[j+1];
        }
        size--;
        return temp;
    }

    public void extendArray(){
        //array of doubled size
        T[] tempArray = (T[]) new Object[this.array.length*2];

        //repopulate new array
        for (int j = 0;j < size; j++){
            tempArray[j] = this.array[j];
        }
        this.array = tempArray;
    }

    public int size(){
        return this.size;
    }

    public void trim(){
        //array trimed to the amount of elements
        T[] tempArray = (T[]) new Object[size];

        for (int i = 0; i < size; i++){
            tempArray[i] = this.array[i];
        }
        this.array = tempArray;
    }

    //for testing purposes
    public int trueSize(){
        return array.length;
    }

    public void print(){
        for (int i = 0; i < size; i++){
            System.out.println(array[i]);
        }
    }

    public boolean isEmpty(){
        if (size == 0)
            return true;
        return false;
    }

}
