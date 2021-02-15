public class StringNode {
    public String data;
    public StringNode next; // null at the end

    public StringNode(String data, StringNode next) {
        this.data = data;
        this.next = next;
    }
}