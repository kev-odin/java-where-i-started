public class dateNight {

    public static void main (String[] args) {
        System.out.println(dateNight2(39.0));
    }

    public static double dateNight2 (double dollars) {
        int entreeCount = 0;
        int appetizerCount = 0;
        int dessertCount = 0;
        
        double entreeCost = 40.0;
        double appetizerCost = 10.0;
        double dessertCost = 7.5;
        double mealPrice = (entreeCost * entreeCount) + (appetizerCost * appetizerCount) + (dessertCost * dessertCount);
    
    
        if (dollars >= entreeCost) {
            dollars = dollars - entreeCost;
            entreeCount ++;
        }
        
        else if (dollars >= appetizerCost && entreeCount == 2) {
            dollars = dollars - appetizerCost;
            appetizerCount ++;
        }
        
        else if (dollars >= dessertCost && entreeCount == 2) {
            dollars = dollars - dessertCost;
            dessertCount ++;
        }       
        return dollars - mealPrice;
    }
}