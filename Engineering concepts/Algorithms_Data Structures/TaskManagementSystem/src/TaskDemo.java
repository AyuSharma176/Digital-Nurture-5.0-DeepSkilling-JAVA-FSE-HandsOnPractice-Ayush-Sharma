public class TaskDemo {
    public static void main(String[] args) {
        TaskLinkedList taskList = new TaskLinkedList();

        taskList.addTask(new Task(1, "Design UI", "In Progress"));
        taskList.addTask(new Task(2, "Setup Database", "Pending"));
        taskList.addTask(new Task(3, "Write Tests", "Pending"));

        System.out.println("All tasks:");
        taskList.traverse();

        System.out.println("\nSearching for task ID 2:");
        Task found = taskList.searchTask(2);
        System.out.println(found != null ? found : "Not found");

        System.out.println("\nDeleting task ID 1:");
        taskList.deleteTask(1);
        taskList.traverse();

        System.out.println("\nTotal remaining tasks: " + taskList.size());
    }
}