import java.util.Scanner;

public class TodoViewer {
    private TodoList todoList;
    private Scanner scanner;

    public TodoViewer() {
        todoList = new TodoList();
        scanner = new Scanner(System.in);
    }

    public void start() {
        // Implement user interface and handle user input
        System.out.println("Welcome to ToDo!");

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Add a to-do item");
            System.out.println("2. Delete a to-do item");
            System.out.println("3. View to-do items");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Please enter items description:");
                    String description = scanner.next();
                    TodoItem item = new TodoItem(description);
                    todoList.addItem(item);
                    break;
                case 2:
                    System.out.println("Please enter items description:");
                    String toDelete = scanner.next();
                    todoList.deleteItem(toDelete);
                    break;
                case 3:
                    todoList.showTodoList();
                    break;
                case 4:
                    System.out.println("Exiting program. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }
}
