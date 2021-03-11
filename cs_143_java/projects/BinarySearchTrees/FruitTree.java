public class FruitTree {
    public static void main(String[] args) {
        // create an empty BST
        BinarySearchTree<String> fruitTree = new BinarySearchTree<>();

        String[] fruits = {"apple", "orange", "kiwi", "cherry", "mango",
                "strawberry", "watermelon", "raspberry", "blueberry", "blackberry", "durian"};

        for(String fruit : fruits){
            // no duplicates in the array, so it should successfully add them all (print true)
            System.out.println(fruitTree.add(fruit));
        }

        // try to add a duplicate (should return false, kiwi already exists)
        System.out.println(fruitTree.add("kiwi"));
        // true because cherry exists
        System.out.println(fruitTree.contains("cherry"));
        // false because peach is not in the tree
        System.out.println(fruitTree.contains("peach"));
        // 11 nodes in the tree
        System.out.println(fruitTree.size());

        fruitTree.printInOrder();
    }
}
