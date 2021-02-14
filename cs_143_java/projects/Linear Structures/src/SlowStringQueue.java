public class SlowStringQueue {
    // the first person in line
    private StringNode beginning;
    // what if we also maintained a direct link to the end of the queue
    // no more walking!

    /**
     * O(n) linear time, we take a performance hit because of the walker that needs to 
     * find the null reference at the end
     * Add a new String to the end of the queue
     * @param data
     */
    public void add(String data){
        // Step 1: construct the new node to go at the end
        StringNode node = new StringNode(data, null);
        // Step 2: What if we are the only person in line?
        if(isEmpty()){
            beginning = node; // we are now the only person in line, so we are at the beginning
        }
        else{
            // Step 3: we need to "walk" to the end of the line
            // problem! we don't have access to the last node! we only have access to the beginning node!
            // we could use a loop to "walk" through the queue until we get to the end
            // then, add our new node to the end
            // we should not change the beginning!
            // A. create a reference to the beginning that we can change without modifying the beginning
            StringNode walker = beginning;
            // B. walk the line to get to the end
            while(walker.rest != null){ // as long as we aren't at the end of the queue
                walker = walker.rest; // moving the walker to the next node
            }
            // C. walker now points to the last node in the queue, now we can add "node" after it
            walker.rest = node;
        }
    }

    /**
     * O(1) constant time
     * Remove the first String from the beginning of the queue
     * @return the String that was removed
     */
    public String remove(){
        // Step 1: save the beginning so we can return it later
        String oldBeginning = beginning.data;
        // Step 2: update the beginning to be whatever is after the current beginning
        beginning = beginning.rest;
        // Step 3: return the data that used to be at the beginning
        return oldBeginning;
    }

    /**
     * Return true if there is at least one thing in the queue,
     * otherwise returns false
     * @return
     */
    public boolean isEmpty(){
        return beginning == null;
    }
}
