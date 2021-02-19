public class DLListMain {
    public static void main(String[] args) {
        DLList<Integer> test = new DLList<>();
        for (int i = 0; i < 5; i++) {
            test.add(i);
            System.out.println("Printing: " + i);
        }
        System.out.println("The size of this DLList is: " + test.size());
        test.remove(4);

        for (int i = 0; i < 4; i++) {
            test.get(i);
            System.out.println("Getting: " + i);
        }
        System.out.println("The size of this DLList is: " + test.size());
        
    }
}
