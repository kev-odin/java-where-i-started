public class WarehouseMain {
    public static void main(String[] args) {
        Warehouse A = new Warehouse(3, 2);
        A.receive(1, 3);
        A.receive(2, 1);
        A.ship(1, 1);

        System.out.println(A);
    }
}
