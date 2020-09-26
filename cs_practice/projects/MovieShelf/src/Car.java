public class Car {
    private int numberOfWheels;
    private int gasMileage;
    private int milesDriven;
    private String modelName;

    public Car(String modelName, int numberOfWheels, int gasMileage, int milesDriven) {
        this.modelName = modelName;
        this.numberOfWheels = numberOfWheels;
        this.gasMileage = gasMileage;
        this.milesDriven = milesDriven;
    }

    public Car(){
    }

    public static void main(String[] args) {
        Car a = new Car("Mazda", 4, 30, 10000);
        System.out.println(a);
    }

    public String toString(){
        return modelName + "\nNumber of wheels: " + numberOfWheels + "\nGas mileage: " + gasMileage + "\nMiles driven: " + milesDriven; 
    }
}
