import java.util.ArrayList;
import java.util.List;
public class TodoList {
    private List<TodoItem> todoItems;

    public TodoList() {
        todoItems = new ArrayList<>();
    }

    public void addItem(TodoItem item) {
        todoItems.add(item);
    }

    public void deleteItem(TodoItem item) {
        if (todoItems.isEmpty()) {
            System.out.println("No to-do items to delete.");
            return;
        }
        else {
            todoItems.remove(item);
        }
    }

    public void deleteItem(String itemDescription)
    {
        if (todoItems.isEmpty()) {
            System.out.println("No to-do items to delete.");
            return;
        }
        else {
            for (int i = 0; i < todoItems.size(); i++) {
                if(todoItems.get(i).getDescription().equals(itemDescription)) {
                    todoItems.remove(todoItems.get(i));
                }
            }
        }
    }

    public void moveItem(int oldIndex, int newIndex) {
        // Move item from oldIndex to newIndex
        TodoItem item = todoItems.remove(oldIndex);
        todoItems.add(newIndex, item);
    }

    public void showTodoList() {
        for (TodoItem item : todoItems) {
            item.viewItem();
        }
    }
}
