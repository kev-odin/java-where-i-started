public class IntTree {
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        int[] intsToAdd = {75, 41, 22, 58, 46, 27, 78, 65, 100, 95, 76, 99};
        for(int i : intsToAdd){
            tree.add(i);
        }

        System.out.println(tree.size());
        System.out.println(tree.height());
        System.out.println(tree.delete(99));
        tree.printStructure();
    }
}
