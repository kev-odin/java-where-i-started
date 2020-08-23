public class Customer {
    private String name;
    private int age;
    private double balance;

    //Constructors
    public Customer(String name, int age, double balance) {
        this.name = name;
        this.age = age;
        this.balance = balance;
    }
    
    public Customer() { // Default cases
        this("No name.", 999, 0.0);
    }

    // Getters and Setters, toString
    @Override
    public String toString() {
        String s = "";
        s += "\nName: " + name;
        s += "\nAge: " + age;
        s += "\nBalance: " + balance;
        return s;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getBalance() {
        return balance;
    }
}
