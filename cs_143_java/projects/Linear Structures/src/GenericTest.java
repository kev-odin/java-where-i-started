import java.util.Arrays;

public class GenericTest {
    public static void main(String[] args) {
        DoublyLinkedList<Double> list = new DoublyLinkedList<Double>();
        for(double i = 0.0; i <= 10.0; i += 0.5){
            list.add(i);
        }

        for(Double d : list){
            System.out.print(d + " ");
        }
        System.out.println();

        DoublyLinkedList<int[]> list1 = new DoublyLinkedList<int[]>();
        int[] a = {1, 2, 3, 4};
        int[] b = {1, 2, 3, 4, 5, 6};
        int[] c = {-1, -2, -3, -4, -5};
        list1.add(a);
        list1.add(b);
        list1.add(c);
        for(int[] array : list1){
            System.out.println(Arrays.toString(array));
        }
    }
}
