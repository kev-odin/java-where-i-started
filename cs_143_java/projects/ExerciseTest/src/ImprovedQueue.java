public class ImprovedQueue {
    public StringNode head;
    public StringNode tail;

    public ImprovedQueue() {
        head = tail = null; // empty queue
    }

    public void add(String x) {
        // Add x to the end of the list
        if (head == null) { // Nobody in line
            head = tail = new StringNode(x, null); // head and tail are the one person in line
        } else { // Tail must not be null
            tail.next = new StringNode(x, null); // Put the new tail after the old tail
            tail = tail.next;
        }
    }

    public static void main(String[] args) {
        ImprovedQueue queue = new ImprovedQueue();
        queue.add("A");
        queue.add("B");
        queue.add("C");
        queue.add("D");
    }
}