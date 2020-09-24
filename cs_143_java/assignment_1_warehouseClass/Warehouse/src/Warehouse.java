public class Warehouse {
    private int size;
    private int limitPerItem;
    private int[] storageRoom;

    public Warehouse(int size, int limitPerItem) {
        this.size = size;
        this.limitPerItem = limitPerItem;
        storageRoom = new int[size];
    }

    public static void main(String[] args) {
        Warehouse A = new Warehouse(3, 2);
        System.out.println(A);
        A.receive(1, 3);
    }

    public int receive(int itemCode, int itemCount) {
        for (int item = 0; item <= itemCount - 1; item++) {
            storageRoom[item] = itemCode;
        }
        return 0;
    }

    public int ship(int itemCode, int itemCount) {
        return 0;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getLimitPerItem() {
        return limitPerItem;
    }

    public void setLimitPerItem(int limitPerItem) {
        this.limitPerItem = limitPerItem;
    }
    public String toString() {
        return "Warehouse size: " + size + "\nWarehouse limit: " + limitPerItem;
    }
}
