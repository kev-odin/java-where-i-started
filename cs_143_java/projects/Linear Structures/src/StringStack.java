public class StringStack {
    private StringNode top; // internal representation of the stack

    /**
     * Create an empty stack with nothing on top
     */
    public StringStack(){
        top = null;
    }

    /**
     * O(1)
     * Push data on top of the stack
     * @param data
     */
    public void push(String data){
        // Step 1: create a new Stack with data on top, and the existing Stack under it
        StringNode newStack = new StringNode(data, top);
        // Step 2: reassign "top" to be this new stack, since "data" is now on top of the stack!
        top = newStack;
    }

    /**
     * O(1)
     * Get and remove the data that is on top of the stack
     * @return top piece of data
     */
    public String pop(){
        // Step 1: save the top so we can return it later
        String oldTop = top.data;
        // Step 2: update the top to be the top of the rest of the stack
        top = top.rest;
        // Step 3: return the data that used to be on top
        return oldTop;
    }

    /**
     * peek returns the value on top of the stack without removing it
     * @return
     */
    public String peek(){
        return top.data;
    }

    /**
     * return the number of Strings in the stack
     * @return
     */
    public int size(){
        return top.size();
    }

    /**
     * returns true if there is nothing in the Stack, otherwise returns false
     * @return
     */
    public boolean isEmpty(){
        return top == null;
    }
}
