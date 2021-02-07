public class Pancakes {
    public static void main(String[] args) {
        // old inconvenient version of a stack
//        StringNode pancakes = null; // empty stack
//        pancakes = new StringNode("chocolate", pancakes); // adding a chocolate pancake to the top
//        pancakes = new StringNode("blueberry", pancakes); // adding a blueberry pancake to the top
//        pancakes = new StringNode("red velvet", pancakes);// adding a red velvet pancake to the top
        //System.out.println(pancakes.size());

        StringStack pancakes = new StringStack(); // empty stack of pancakes
        pancakes.push("chocolate");
        pancakes.push("blueberry");
        pancakes.push("red velvet");
        pancakes.push("cinnamon");
        pancakes.push("strawberry");
        pancakes.push("triple chocolate");
        pancakes.push("vanilla");

        System.out.println(pancakes.size());

        while(!pancakes.isEmpty()){
            System.out.println(pancakes.pop());
        }
    }
}
