
public class CharacterCreator {
    public static void main(String[] args) {
        Adventurer alara = new Adventurer(10, 12, 17);
        alara.setName("Alara Silver");
        alara.setJob("Mage");

        alara.introSelf();
        alara.listStats();
        System.out.println();

        Adventurer thud = new Adventurer("Thud", "Barbarian", 18, 15, 7); // constructor chaining
        thud.introSelf();
        thud.listStats();
        System.out.println();

        Monster goblin = new Monster(7, "Warg");

        thud.attack(goblin);

        Spellcaster ara = new Spellcaster("Ara", "Wizard", 8, 13, 18, 20);
        ara.heal(thud);
    }
}