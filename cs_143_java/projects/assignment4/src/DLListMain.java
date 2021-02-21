public class DLListMain {
    public static void main(String[] args) {
        DLList<Integer> test = new DLList<>();
        for (int i = 0; i < 3; i++) {
            test.add(i);
            System.out.println("Printing: " + i);
        }
        System.out.println("The size of this DLList is: " + test.size());

        for (int i = 0; i < 3; i++) {
            System.out.println("Printing: " + i);
        }
    }
}
