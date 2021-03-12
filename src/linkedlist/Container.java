package linkedlist;

class Container<T> {
    private Container previous;
    private Container next;
    private T payload;

    Container(Container previous, Container next, T payload) {
        this.previous = previous;
        this.next = next;
        this.payload = payload;
    }

    Container(T payload) {
        this.payload = payload;
    }

    Container getPrevious() { return previous; }
    Container getNext() { return next; }
    T getPayload() { return payload; }

    void setPrevious(Container previous) { this.previous = previous; }
    void setNext(Container next) { this.next = next; }
    void setPayload(T payload) { this.payload = payload; }

    boolean hasPrevious() { return previous != null; }
    boolean hasNext() { return next != null; }
}