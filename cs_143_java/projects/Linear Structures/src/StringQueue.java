public class StringQueue {
    // the first person in line
    private StringNode beginning;
    // What if we also maintained a direct link to the end of the queue?
    // no more walking!

    // the last person in line
    private StringNode end;

    public StringQueue(){ //default constructor
        beginning = null;
        end = null;
    }

    /**
     * O(1) constant time
     * Add a new String to the end of the queue
     * @param data
     */
    public void add(String data){
        // Step 1: construct the new node to go at the end
        StringNode node = new StringNode(data, null);
        // Step 2: What if we are the only person in line?
        if(isEmpty()){
            beginning = node; // we are now the only person in line, so we are at the beginning
            end = node; // since we are the only person in line, we are also the end of the line!
        }
        else{
            // we no longer need to "walk" to the end of the line!
            // we can use the "end" reference to teleport there
            end.rest = node; // add new node after the end
            end = node; // update the end to be the new end
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

        // Step 3: is the queue now empty?
        if(isEmpty()){
            // update the end to also reference null\
            end = null;
        }

        // Step 4: return the data that used to be at the beginning
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