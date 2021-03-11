/*
    Binary Search Trees can be made generic, but
    we need to make sure that the types substituted for T
    are Objects that we can compare to each other
    (since we need to be able to do this to preserve the ordering/definition of a BST)

    T extends Comparable<T>> makes our BST generic, but it can only accept types
    that implement the Comparable interface
 */
public class BinarySearchTree<T extends Comparable<T>> {
    // inner class to represent a single node of the tree
    private static class Node<T>{
        // each node has 3 properties: data, left, right
        private T data;         // the data this node holds
        private Node<T> left;   // link to all the nodes < this node
        private Node<T> right;  // link to all the nodes > this node

        /**
         * Create a leaf node (no children)
         * @param data
         */
        public Node(T data){
            this.data = data;
            left = null;
            right = null;
        }
    }

    private Node<T> root; // top node of the tree (all nodes are descendants)

    /**
     * Create an empty binary search tree (root is null, no nodes/data in the tree)
     */
    public BinarySearchTree(){
        root = null;
    }

    /**
     * Add data to the BST
     * @param data
     * @return true if the new data was successfully added (was not already in the tree), otherwise false
     */
    public boolean add(T data){
        if(root == null){ // if the tree is empty
            // construct a new node to be the root
            root = new Node<>(data);
            // return true, since adding was successful
            return true;
        }
        return add(data, root);
    }

    private boolean add(T data, Node<T> tree){
        // compare data to the data in root of tree
        int dataVsNode = data.compareTo(tree.data);
        // if dataVsNode < 0, then data should go in the left subtree
        if(dataVsNode < 0){
            // we know that data should go in the left subtree (tree.left)
            // if the left subtree does not exist, then we found the spot where data should go
            if(tree.left == null){
                // this is where data belongs!
                tree.left = new Node<>(data);
                return true;
            }
            else{
                // recursively call the method on the left subtree (reduce to a smaller problem!)
                return add(data, tree.left);
            }
        }
        // if dataVsNode > 0, then data should go in the right subtree
        else if(dataVsNode > 0){
            // we know that data should go in the right subtree (tree.right)
            // if the right subtree does not exist, then we found the spot where data should go
            if(tree.right == null){
                // this is where data belongs!
                tree.right = new Node<>(data);
                return true;
            }
            else{
                // recursively call the method on the right subtree (reduce to a smaller problem!)
                return add(data, tree.right);
            }
        }
        // if dataVsNode == 0, then data is already in the tree, should not be added again
        else {
            // data == tree.data (already in the tree)
            return false;
        }
    }

    /**
     * Find and delete the node that contains "data" from the tree if it exists
     * @param data the value we want to remove from the tree
     * @return true if the removal was successful, otherwise false
     */
    public boolean delete(T data){
        return delete(data, root);
    }

    /**
     * Find and delete the node that contains "data" from the tree if it exists in the tree with "tree" as its root
     * @param data the value we want to remove from the tree
     * @param tree the root of the subtree we are searching through
     * @return true if the removal was successful, otherwise false
     */
    private boolean delete(T data, Node<T> tree){
        // what if the tree is empty?
        if(tree == null){
            // there is nothing to remove from an empty tree
            return false;
        }
        // otherwise, compare "data" to "tree.data" (the root of the current subtree) to determine how to proceed
        int dataVsNode = data.compareTo(tree.data);
        // if dataVsNode is 0, then data == tree.data
        if(dataVsNode == 0){
            // we found the node that contains "data" (the node we want to delete)
            deleteRoot(tree);
            return true;
        }
        // if dataVsNode < 0, then data < tree.data
        else if(dataVsNode < 0){
            // recursively try to delete the node from the left subtree
            return delete(data, tree.left);
        }
        // if dataVsNode > 0, then data > tree.data
        else{
            // recursively try to delete the node from the right subtree
            return delete(data, tree.right);
        }
    }

    /**
     * Utility to delete the root of a particular subtree
     */
    private void deleteRoot(Node<T> tree){
        // what if the tree is a leaf (both subtrees are null)
        if(tree.left == null && tree.right == null){
            tree = null; // clear out the tree
        }
        // what if the left subtree is null?
        // replace the node with it's right subtree
        else if(tree.left == null){
            tree.data = tree.right.data;
            tree.left = tree.right.left;
            tree.right = tree.right.right;
        }
        // what if the right subtree is null?
        // replace the node with its left subtree
        else if(tree.right == null){
            tree.data = tree.left.data;
            tree.right = tree.left.right;
            tree.left = tree.left.left;
        }
        // what if both subtrees are non-null
        // go and find a successor (the next-in-line node in sorted order)
        // In other words, the lowest node that is greater than the node we are deleting
        else{
            // go right first
            Node<T> successor = tree.right;
            // go left as many times as we can
            // What if we cannot go left at all?
            if(successor.left == null){
                // successor is already the appropriate successor
                // since if we cant go left, then this node is already the leftmost node in the right subtree
                tree.data = successor.data; // replacing the root's data with the successor's data
                tree.right = tree.right.right; // bypass the successor
            }
            // otherwise, go left until the leftmost node is found
            else{
                Node<T> successorParent = null;
                // while we can go left
                while(successor.left != null){
                    successorParent = successor;
                    successor = successor.left; // go left
                }
                // after the successor has been found we will replace the root with the successor's data
                tree.data = successor.data;
                // clear out the successor by assigning successorParent's left to the successor's right subtree
                successorParent.left = successor.right;
            }
        }
    }

    /**
     * Return true if data is in the tree, otherwise false
     *
     * @param data
     * @return
     */
    public boolean contains(T data){
        // We will hand off the work to a recursive helper method
        return contains(data, root);
    }

    private boolean contains(T data, Node<T> tree){
        // if the tree is empty, it does not contain data
        if(tree == null){
            return false;
        }

        // otherwise, we know the tree is not null, so we need to compare
        // data to tree.data to see which subtree to search in
        // compare data to the data in root of tree
        int dataVsNode = data.compareTo(tree.data);
        // check if the tree's root contains the data
        if(dataVsNode == 0){
            // parameter data equals the tree root's data
            return true;
        }
        // determine if the data would be in the left subtree
        else if(dataVsNode < 0){
            // recursively check if this node exists in the left subtree
            return contains(data, tree.left);
        }
        // determine if the data would be in the right subtree
        else{
            // recursively check if this node exists in the right subtree
            return contains(data, tree.right);
        }
    }

    /**
     * Return the number of nodes in the BST
     *
     * @return
     */
    public int size(){
        return size(root);
    }

    /*
       Consider a subtree called tree whose root is a node in the tree

       The size of "tree" is equal to:
            size(tree.left) + size(tree.right) + 1

     */
    private int size(Node<T> tree){
        // what if the tree is empty?
        if(tree == null){
            return 0;
        }
        // otherwise, recursively count the number of nodes in the left subtree
        // and the number of nodes in the right subtree
        // add them together, and add 1 so that the root is counted too
        return size(tree.left) + size(tree.right) + 1;
    }

    /**
     * The height of a BST is equal to the height of its tallest subtree + 1
     *
     * The height of an empty tree is 0
     * The height of a tree with just a root (single node) is 1
     * @return
     */
    public int height(){
        return height(root);
    }

    private int height(Node<T> tree){
        // is this tree empty?
        if(tree == null){
            return 0; // height of an empty tree is 0
        }
        // is this tree a leaf? (no left or right subtrees)
        if(tree.left == null && tree.right == null){
            return 1; // height of a leaf is 1
        }
        // recursively calculate the height of the left and right subtrees
        int leftHeight = height(tree.left);
        int rightHeight = height(tree.right);

        // find which one is taller!
        if(leftHeight > rightHeight){
            return leftHeight + 1;
        }
        else{ // rightHeight is >= leftHeight
            return rightHeight + 1;
        }
    }

    /**
     * Print out all the data in the BST in order
     */
    public void printInOrder(){
        printInOrder(root);
    }

    /**
     * Recursively print a subtree rooted at tree
     * @param tree
     */
    private void printInOrder(Node<T> tree){
        // what if the tree is empty? Print nothing
        if(tree == null){
            // nothing to print
            return; // stop the recursion
        }
        // first, print all the nodes in the left subtree (less than root)
        printInOrder(tree.left);
        // second, print the root
        System.out.println(tree.data);
        // third, print all the nodes in the right subtree (greater than root)
        printInOrder(tree.right);
    }

    /**
     * Print out the tree structure sideways
     * Use indentation to indicate that nodes are children of other nodes
     */
    public void printStructure(){
        printStructure(root, 0);
    }

    private void printStructure(Node<T> tree, int indent){
        // is the tree empty? if so, there is nothing to print!
        if(tree == null){
            return;
        }
        // 1. print the right subtree with 1 more level of indentation
        printStructure(tree.right, indent + 1);
        // 2. print the root with the current level of indentation
        // use a for loop to handle the indentation
        for(int i = 0; i < indent; i++){
            System.out.print("\t"); // one tab per level of indentation
        }
        System.out.println(tree.data);
        // 3. print the left subtree with 1 more level of indentation
        printStructure(tree.left, indent + 1);
    }
}
