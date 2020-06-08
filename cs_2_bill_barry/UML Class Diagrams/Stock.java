public class Stock {
    private String symbol;
    private String name;
    private double prevClosingPrice;
    private double currentPrice;

    // Constructors
    public Stock() {
        this.symbol = "No symbol name.";
        this.name = "No name provided.";
    }

    public Stock(String symbol, String name) {
        this.symbol = symbol;
        this.name = name;
        getChangePercent(currentPrice, prevClosingPrice);
    }

    public String toString() {
        String s = "";
        s += "\nSymbol\t: " + getSymbol();
        s += "\nName\t: " + getName();
        s += "\nPCP\t: " + getChangePercent(currentPrice, prevClosingPrice);
        return s;
    }

    // Methods
    public double getChangePercent(double currentPrice, double prevClosingPrice) {
        return Math.abs(currentPrice - prevClosingPrice) * 100.0;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrevClosingPrice() {
        return prevClosingPrice;
    }

    public void setPrevClosingPrice(double prevClosingPrice) {
        this.prevClosingPrice = prevClosingPrice;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }    

    // Testing
    public static void main(String[] args) {
        Stock firstStock = new Stock("ORCL", "Oracle Corporation");
        firstStock.setPrevClosingPrice(34.5);
        firstStock.setCurrentPrice(34.45);
        System.out.println(firstStock);

    }

}