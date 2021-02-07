/**
 * Recursively defined list of Strings
 */
public class StringNode {
    // these properties should be private, but we will leave them as public for simplicity
    public String data;
    public StringNode rest;

    public StringNode(String data, StringNode rest) {
        this.data = data;
        this.rest = rest;
    }

    /**
     * The size of a list of Strings is 1 + the size of the list of Strings after the first String
     * @return
     */
    public int size(){
        if(rest == null){
            return 1; // just have 1 String
        }
        return 1 + rest.size();
    }
}
