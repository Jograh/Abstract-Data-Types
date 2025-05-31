//THIS CODE IS INCOMPLETE
//Still missing addFirst, addLast, remove, size, isEmpty;

public class NodeList<T> {

    private Position first;
    private Position last;


    public class Position{
        private T data;
        private Position previous;
        private Position next;

        public Position(T data, Position previous, Position next){
            this.data = data;
            this.previous = previous;
            this.next = next;
        }

        public T element(){
            return this.data;
        }

        @Override
        public String toString(){
            if (this.data != null)
            return this.data.toString();

            else return null;
        }
    }

    //constructor
    public NodeList() {
        first = new Position(null, null, last);
        last = new Position(null, first, null);
    }

    //getters
    public Position getFirst(){
        return first;
    }
    public Position getLast(){
       return last;
    }

    public Position prev(Position p){
        return p.previous;
    }
    public Position next(Position p){
        return p.next;
    }

    public void addBefore(Position p, T e){
        Position beforePosition = p.previous;
        Position atPosition = p;

        //sandwich new data then update old ones
        Position newPosition = new Position(e, beforePosition, atPosition);
        beforePosition.next = newPosition;
        atPosition.previous = newPosition;
    }

    public void addAfter(Position p, T e){
        Position atPosition = p;
        Position nextPosition = p.next;

        Position newPosition = new Position(e, atPosition, nextPosition);
        atPosition.next = newPosition;
        nextPosition.previous = newPosition;
    }

}
