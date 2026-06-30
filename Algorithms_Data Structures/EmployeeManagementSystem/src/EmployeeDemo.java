public class EmployeeDemo {
    public static void main(String[] args) {
        EmployeeArrayManager manager = new EmployeeArrayManager(10);

        manager.addEmployee(new Employee(1, "John Smith", "Manager", 75000));
        manager.addEmployee(new Employee(2, "Sara Lee", "Developer", 65000));
        manager.addEmployee(new Employee(3, "Mike Chen", "Designer", 60000));

        System.out.println("All employees:");
        manager.traverse();

        System.out.println("\nSearching for employee ID 2:");
        Employee found = manager.searchEmployee(2);
        System.out.println(found != null ? found : "Not found");

        System.out.println("\nDeleting employee ID 1:");
        manager.deleteEmployee(1);
        manager.traverse();
    }
}