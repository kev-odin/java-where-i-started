import java.util.Iterator;

public class DoublyTest {
    public static void main(String[] args) {
//        DoublyLinkedList list = new DoublyLinkedList(); // empty list
//        list.add("A");
//        list.add("B");
//        list.add("C");
//        list.add("D");
//        // <- A -> <- B -> <- C -> <- D ->
//        System.out.println(list.get(0));
//        System.out.println(list.get(1));
//        System.out.println(list.get(2));
//        System.out.println(list.get(3));
//        System.out.println(list.get(4));
//        System.out.println(list.get(-1));

        DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
        int size = 40000;
        for(int i = 0; i < size; i++){
            list.add(i); // "0", "1", "2", ...
        }

        System.out.println("Starting slow approach...");
        // O(n^2)
        for(int i = 0; i < size; i++){
            list.get(i); // print the String at index i
        }
        System.out.println("Ending slow approach...");

        System.out.println("Starting fast approach...");
        // asking the list to return to us a Conductor
        // special type of for loop that can be used with any class that implements Iterable
        // O(n)
        // for each string s in our list....print s
        for (Integer s : list) { // as long as the iterator has more nodes to visit
            //System.out.println(s);
        }
        System.out.println("Ending fast approach...");


        DoublyLinkedList<String> list1 = new DoublyLinkedList<String>(); // empty list
        list1.add("A");
        list1.add("B");
        list1.add("C");
        list1.add("D");
        list1.remove(2); // remove the C
        // <- A -> <- B -> <- D ->
        System.out.println(list1.get(0));
        System.out.println(list1.get(1));
        System.out.println(list1.get(2));
//        System.out.println(list1.get(3)); we can no longer do this, because the length is now 3
        list1.remove(0); // remove the A
        // <- B -> <- D ->
        list1.remove(1); // remove the D
        System.out.println("Elements left after removal: ");
        for(String s : list1){
            System.out.println(s);
        }
        // behind the scenes, this uses our iterator

//        int[] a = {1, 2, 3, 4, 5};
        // these two for loops are equivalent
//        for(int i = 0; i < a.length; i++){
//            System.out.println(i);
//        }
//        for(int i : a){
//            System.out.println(i);
//        }

    }
}
