public class EmployeeArrayManager {
    private Employee[] employees;
    private int size;

    public EmployeeArrayManager(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    // Add: O(1) amortized (assuming space available)
    public boolean addEmployee(Employee employee) {
        if (size >= employees.length) {
            System.out.println("Array is full. Cannot add more employees.");
            return false;
        }
        employees[size++] = employee;
        return true;
    }

    // Search: O(n) - must scan until match found
    public Employee searchEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    // Traverse: O(n) - visits every element
    public void traverse() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    // Delete: O(n) - find element, then shift subsequent elements left
    public boolean deleteEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                for (int j = i; j < size - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[size - 1] = null;
                size--;
                return true;
            }
        }
        return false;
    }
}