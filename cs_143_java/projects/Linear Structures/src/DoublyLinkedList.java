import java.util.Iterator;

public class DoublyLinkedList<T> implements Iterable<T>{ // T is placeholder for any type of Object

    // inner class to represent one Node of the DLList
    private static class Node<T> {
        public T data; // the data this node holds
        public Node<T> prev;   // the node "before" this node in the list
        public Node<T> next;   // the node "after" this node in the list

        public Node(Node<T> prev, T data, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    // Data members of the DoublyLinkedList class
    // access points to the list: beginning and the end
    private Node<T> head; // first node in the list
    private Node<T> tail; // last node in the list

    /**
     * Create an empty DoublyLinkedList
     */
    public DoublyLinkedList(){
        head = tail = null; // there are no nodes in an empty list, so head and tail are null
    }

    /**
     * Add a new piece of data in a node at the end of the list (1) 25:01, February 9, 2021
     * @param data
     */
    public void add(T data){ //February 9, 2021
        // two cases: the list is empty or not
        if(isEmpty()){
            // Nothing in the list, so the new node should be both the head and tail
            // Nothing before/after the new node, next/prev is null
            head = tail = new Node<T>(null, data, null);
        }
        else{
            // Something is in the list, add the new node to the end of the list
            // first, the new node's prev should reference the old tail (link it to what used to be the end)
            // since this node is now the end, its next should be null
            Node<T> n = new Node<T>(tail, data, null);
            // make the current last node (tail) have a forward reference to the new last node (n)
            tail.next = n;
            // since we are adding to the end of the list, we will need to update the tail
            tail = n;
        }
    }

    /**
     * Access and remove the ith element from the list (0-based indexing)
     * @param i index
     * @return data that was stored at the removed index
     */
    public T remove(int i){
        if(i < 0){
            throw new IndexOutOfBoundsException(); // i was a negative index (less than the lowest index of 0)
        }
        // create a walker node (we do not want to modify the head)
        Node<T> n = head;
        // walk walker to the desired index
        for(int j = 0; j < i && n != null; j++){
            n = n.next;
        }
        if(n == null){
            throw new IndexOutOfBoundsException(); // i was greater than the greatest index
        }

        // if an exception was not thrown, that means i was a valid index and n now
        // holds a reference to the node we are removing
        Node<T> nprev = n.prev; // node before n
        Node<T> nnext = n.next; // node after n
        // Are we removing the first node?
        if(nprev == null){
            // we are removing the first node!
            nnext.prev = null; // now nnext has no nodes before it
            head = nnext; // since we removed the first node, the node that came after it should be the head
        }
        // Are we removing the last node?
        else if(nnext == null){
            // we are removing the last node!
            nprev.next = null; // now nprev has no nodes after it
            tail = nprev; // since we removed the last node, the node that came before it should be the tail
        }
        // Are we removing a node in the middle?
        else{
            // we are removing a node in the middle!
            nprev.next = nnext; // the node before n should reference the node after n
            nnext.prev = nprev; // the node after n should reference the node before n
        }

        // the only variable reference the node we are removing is the n variable (which is a local variable to this method)
        // when this method returns, the local variable n goes away and the Garbage Collector will throw away
        // the node we removed
        return n.data;
    }

    /**
     * O(n) because in the worst case, the index is at the end of the list
     *  walk from the head to the end
     * Access the data stored at index i in the list (0 based)
     * @param i index
     * @return data in the ith node
     */
    public T get(int i){
        if(i < 0){
            throw new IndexOutOfBoundsException(); // i was a negative index (less than the lowest index of 0)
        }
        // create a walker node (we do not want to modify the head)
        Node<T> walker = head;
        // walk walker to the desired index
        for(int j = 0; j < i && walker != null; j++){
            walker = walker.next;
        }
        if(walker == null){
            throw new IndexOutOfBoundsException(); // i was greater than the greatest index
        }
        // walker should now be at index i, return the data at that index
        return walker.data;
    }

    /**
     * return true if there is nothing in the list, otherwise false
     * @return
     */
    public boolean isEmpty(){ // part of the add method
        return head == null; // is the head of the list null? 29:30 February 9, 2021
    }

    @Override
    public Iterator<T> iterator() {
        return new Conductor<T>(head); // return an iterator that starts at the front (head) of the list
    }

    // iterator class that will allow us to traverse the DLList in O(n)
    private static class Conductor<T> implements Iterator<T>{
        // the conductor needs to remember what car in the train she is on
        private Node<T> current; // the current Node the iterator is "visiting"

        // start the iteration on the Node that we pass into the constructor
        public Conductor(Node<T> current) {
            this.current = current;
        }

        @Override
        public boolean hasNext() {
            // if we are at the end of the list, we will be looking at null
            // otherwise we are looking at a node (which means we are not at the end
            return current != null;
        }

        @Override
        public T next() {
            // 1. remember the String in the current node
            T res = current.data;
            // 2. move current to the next node
            current = current.next;
            // 3. return the String we remembered
            return res;
        }
    }
}
