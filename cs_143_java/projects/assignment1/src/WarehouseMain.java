public class WarehouseMain {
    public static void main(String[] args) {
        //Warehouse A = new Warehouse(3, 2);
        //A.receive(1, 3); //return one 1's, store two 1's
        //A.receive(2, 1); //return 0;
        //A.ship(1, 1);   // return 1;

        Warehouse w = new Warehouse(3, 4);
        w.receive(6, 1);
        w.receive(1, 2);
    }
}
