public class Pizza {
    // instance variables

    // enumerated types? - useful in this situation 
    public enum pizzaType {CHEESE, PEPPERONI, VEGGIE};
    public enum pizzaSize {SMALL, MEDIUM, LARGE, XL};

    // constants 
    public static final int SMALL_DIAM = 9;
    public static final int MEDIUM_DIAM = 12;
    public static final int LARGE_DIAM = 16;
    public static final int XL_DIAM = 18;

    // private data
    private pizzaType type;
    private pizzaSize size;
    private boolean thinCrust;
    private String specInstruct;

    // constructor for objects of class pizza - all parameter
    public Pizza(pizzaType type, pizzaSize size, boolean thinCrust, String specInstruct) {
        this.type = type;
        this.size = size;
        this.thinCrust = thinCrust;
        this.specInstruct = specInstruct;
    }

    // pizza object with 2 parameters
    public Pizza(pizzaType type, pizzaSize size) {
        this(type, size, false, ""); // call the current constructor and pass in the argeuments
    }

    // pizza object with default values, no parameters
    public Pizza() {
        this(pizzaType.PEPPERONI, pizzaSize.LARGE);
    }

    // methods for this Pizza object, easier to read without curly braces
    public double getArea() {
        double diameter;
        if      (size == pizzaSize.SMALL)   diameter = SMALL_DIAM;
        else if (size == pizzaSize.MEDIUM)  diameter = MEDIUM_DIAM;
        else if (size == pizzaSize.LARGE)   diameter = LARGE_DIAM;
        else                                diameter = XL_DIAM;
        
        return Math.pow(diameter / 2.0, 2) * Math.PI;
    }

    // Getters and Setters
    @Override
    public String toString() { 
        String s = "";
        s += "Type: " + type + "\n";
        s += "Size: " + size + "\n";
        s += "Thin Crust: " + ((thinCrust) ? "Yes" : "No") + "\n"; //condition in parathensis, then ? (ternary operator), return true - "Yes" : return false - "No"
        s += "Special :" + specInstruct;
        return s;
    }

    public pizzaType getType() {
        return type;
    }

    public void setType(pizzaType type) {
        this.type = type;
    }

    public pizzaSize getSize() {
        return size;
    }

    public void setSize(pizzaSize size) {
        this.size = size;
    }

    public boolean isThinCrust() {
        return thinCrust;
    }

    public void setThinCrust(boolean thinCrust) {
        this.thinCrust = thinCrust;
    }

    public String getSpecInstruct() {
        return specInstruct;
    }

    public void setSpecInstruct(String specInstruct) {
        this.specInstruct = specInstruct;
    }

    public static void test() { // learning how to test
        System.out.println("\nUnit test on the Pizza class has started. Failures will be shown here: ");

        //Test the constructors
        Pizza testPizza = new Pizza();

        if (testPizza.getType() != pizzaType.PEPPERONI)     System.out.println("getType failed; expected PEPPERONI, got " + testPizza.getType());
        if (testPizza.getSize() != pizzaSize.LARGE)         System.out.println("getSize failed; expected LARGE, got " + testPizza.getSize());
        if (testPizza.isThinCrust())                        System.out.println("isThinCrust failed; expected false, got " + testPizza.isThinCrust());
        if (!testPizza.getSpecInstruct().isEmpty())         System.out.println("getSpecInstruct failed; expected this field to be empty, got " + testPizza.getType());
    
        Pizza testPizza2 = new Pizza(pizzaType.CHEESE, pizzaSize.XL);

        if (testPizza2.getType() != pizzaType.CHEESE)       System.out.println("getType failed; expected CHEESE, got " + testPizza2.getType());
        if (testPizza2.getSize() != pizzaSize.XL)           System.out.println("getSize failed; expected XL, got " + testPizza2.getSize());
        if (testPizza2.isThinCrust())                       System.out.println("isThinCrust failed; expected false, got " + testPizza2.isThinCrust());
        if (!testPizza2.getSpecInstruct().isEmpty())        System.out.println("getSpecInstruct failed; expected this field to be empty, got " + testPizza2.getType());

        Pizza testPizza3 = new Pizza(pizzaType.VEGGIE, pizzaSize.SMALL, true, "No cheese please.");

        if (testPizza3.getType() != pizzaType.VEGGIE)       System.out.println("getType failed; expected PEPPERONI, got " + testPizza3.getType());
        if (testPizza3.getSize() != pizzaSize.SMALL)        System.out.println("getSize failed; expected SMALL, got " + testPizza3.getSize());
        if (!testPizza3.isThinCrust())                      System.out.println("isThinCrust failed; expected false, got " + testPizza3.isThinCrust());
        if (testPizza3.getSpecInstruct().isEmpty())         System.out.println("getSpecInstruct failed; expected this field to be empty, got " + testPizza3.getType());

    }

    public static void main(String[] args) {
        test();
    }

}