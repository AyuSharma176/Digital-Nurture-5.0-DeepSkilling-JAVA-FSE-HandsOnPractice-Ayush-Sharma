public class MVCPatternDemo {
    public static void main(String[] args) {
        Student student = new Student("Alice Johnson", "S1001", "A");
        StudentView view = new StudentView();

        StudentController controller = new StudentController(student, view);

        controller.updateView();

        // Update details through the controller
        controller.setStudentGrade("A+");
        controller.updateView();
    }
}