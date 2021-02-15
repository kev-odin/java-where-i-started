public class DoublyLinkedList {
    private Node head, tail;
    private static class Node {
      public Node prev, next;
      public String data;
      public Node(Node prev, String data, Node next) {
        this.prev = prev;
        this.next = next;
        this.data = data;
      }
    }
    public DoublyLinkedList() {
      head = tail = null;
    }
   
    /**
    * Add data to the end (tail) of the DoublyLinkedList 
    */
    public void add(String data) {
      if (tail == null) {
        head = tail = new Node(null, data, null);
      } else {
        assert(tail.next == null);
        tail.next = new Node(tail, data, null);
        tail = tail.next;
      }
    }
   
    /**
    * Retrieve an element from the middle of the list
    * @param i Zero-based index of the element to retrieve
    * @return The element (TBD: what to do if i is invalid)
    */
    public String get(int i) {
      Node current = head;
      for (int j = 0; j < i; j++) {
        // Count our way up to the desired element
        current = current.next;
      }
      return current.data;
    } 

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(list.get(-1));
    }
  }