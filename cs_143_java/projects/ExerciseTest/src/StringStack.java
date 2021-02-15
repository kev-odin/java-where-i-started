public class StringStack {
    private StringStackItem top;

    public StringStack() {
        // Create an empty stack
        top = null;
    }

    public void push(String s) {
        StringStackItem item = new StringStackItem();
        item.data = s;
        item.rest = top;
        top = item;
    }

    // public String toString() {
    // return "[" + top.toString() + "]";
    // }

    // public String toString() {
    // if (top == null) return "[]";
    // return "[" + toString() + "]";
    // }

    public String toString() {
        if (top == null)
            return "[]";
        return "[" + top.toString() + "]";
    }

    // public String toString() {
    // return "[" + toString() + "]";
    // }

    public class StringStackItem {
        String data; // Top of the stack at this point
        StringStackItem rest; // Rest of the stack

        public String toString() {
            if (rest == null)
                return data;
            return data + ", " + rest.toString();
        }
    }

    public static void main(String[] args) {
        StringStack test = new StringStack();
        test.push("1");
        test.push("2");
        test.push("3");
        System.out.println(test);
    }
}