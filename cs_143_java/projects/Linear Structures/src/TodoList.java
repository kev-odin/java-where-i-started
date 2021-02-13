public class TodoList {
    public static void main(String[] args) {
        StringQueue todo = new StringQueue();
        todo.add("Wash my car");
        todo.add("Buy some groceries");
        todo.add("Eat lunch");
        todo.add("Grade Java Programs");
        todo.add("Read a book");

        while(!todo.isEmpty()){
            System.out.println(todo.remove());
        }
        System.out.println("Done");
    }
}
