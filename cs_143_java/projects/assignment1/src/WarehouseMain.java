public class WarehouseMain {
    public static void main(String[] args) {
        //Warehouse A = new Warehouse(3, 2);
        //A.receive(1, 3); //return one 1's, store two 1's
        //A.receive(2, 1); //return 0;
        //A.ship(1, 1);   // return 1;

        //Warehouse w = new Warehouse(3, 4);
        //w.receive(6, 1);
        //w.receive(1, 2);

        Warehouse w = new Warehouse(8, 3);
        w.receive(16, 2);
        w.receive(1, 4);
        w.receive(9, 4);
        w.receive(15, 2);

        w.ship(1, 5);
        w.ship(2, 2);
        w.ship(11, 2);

        w.receive(12, 1);
        w.receive(12, 4);
        w.receive(1, 2);

        w.ship(11, 1);
        w.ship(14, 5);

        w.receive(14, 3);

        w.ship(9, 3);

    }
}
