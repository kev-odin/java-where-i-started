public class Warehouse {
    private int size;
    private int limitPerItem;
    public Warehouse(int size, int limitPerItem) {
        this.size = size;
        this.limitPerItem = limitPerItem;
    }

    public int receive(int itemCode, int itemCount) {
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
}
