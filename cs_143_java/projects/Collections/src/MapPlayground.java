import java.util.Map;
import java.util.TreeMap;

public class MapPlayground {
    public static void main(String[] args) {
        Map<String, Integer> phonebook = new TreeMap<String, Integer>(); // map from names to phone numbers

        // the put method is used to create a correspondence between a key and a value
        phonebook.put("David Anderson", 1234567890);
        phonebook.put("Jay Inslee", 1111111111);
        phonebook.put("Michael Scott", 1110000101);
        phonebook.put("Sheldon Cooper", 1121212222);
        // since keys are unique we cannot add another pair with David Anderson as the key
        // so the map will just override the current entry with the new value
        phonebook.put("David Anderson", 0);

        System.out.println(phonebook);
        System.out.println(phonebook.get("Michael Scott")); // retrieve the value that Michael Scott maps to
        System.out.println(phonebook.get("Batman")); // null because there is no batman key in the map!

        System.out.println(phonebook.containsKey("Sheldon Cooper")); // true
        System.out.println(phonebook.containsKey("Spiderman")); // false

        // we can get access to the key set (keySet method) and the value set (values method) by using the associated methods
        System.out.println(phonebook.keySet());
        System.out.println(phonebook.values());

    }
}
