import javax.swing.plaf.synth.SynthUI;
import java.util.Set;
import java.util.TreeSet;

public class SetPlayground {
    public static void main(String[] args) {
        // creating a set!
        Set<String> s = new TreeSet<String>();
        s.add("Chipmunk"); // Chipmunk is a member of the set s
        s.add("Woodchuck"); // Woodchuck is a member of the set s
        s.add("Possum"); // Possum is a member of the set s
        System.out.println(s);
        s.add("Possum");
        System.out.println(s); // the set is the same, because Possum was already in the set
        s.add("Squirrel");
        // notice that that the elements are printed in alphabetical order
        // This is a feature of TreeSets where the elements are organized in
        // alphabetical order
        System.out.println(s);

        // we can ask a set is something a member of it?, which will give us a boolean
        //System.out.println(s.contains("Squirrel")); // YES!
        //System.out.println(s.contains("Mouse")); // NO!

        Set<String> a = new TreeSet<String>();
        Set<String> b = new TreeSet<String>();
        a.add("apple"); // One "apple" added to a
        b.add("apple");
        b.add("apple"); // Two "apple"s added to b
        System.out.println(b.equals(a)); // Do a and b represent the same set?
    }
}
