package Week1_Fundamentals;

// 2. Define Model Class
class Student {
    private String name;
    private String id;
    private String grade;

    public Student(String name, String id, String grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }
}

// 3. Define View Class
class StudentView {
    public void displayStudentDetails(String studentName, String studentId, String studentGrade) {
        System.out.println("----- Student Details -----");
        System.out.println("Name:  " + studentName);
        System.out.println("ID:    " + studentId);
        System.out.println("Grade: " + studentGrade);
        System.out.println("---------------------------");
    }
}

// 4. Define Controller Class
class StudentController {
    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    public void setStudentName(String name) { model.setName(name); }
    public String getStudentName() { return model.getName(); }

    public void setStudentGrade(String grade) { model.setGrade(grade); }
    public String getStudentGrade() { return model.getGrade(); }

    public void updateView() {
        view.displayStudentDetails(model.getName(), model.getId(), model.getGrade());
    }
}

// 5. Test the MVC Implementation
public class MVCPatternExample {
    public static void main(String[] args) {
        System.out.println("--- Testing MVC Pattern ---");

        // Fetch student record from database/mock data
        Student model = new Student("Alice Smith", "S101", "A");

        // Create view to display information
        StudentView view = new StudentView();

        // Wire them up using Controller
        StudentController controller = new StudentController(model, view);

        // Display initial data
        controller.updateView();

        // Update data through controller
        System.out.println("\nUpdating student record...");
        controller.setStudentName("Alice Jones");
        controller.setStudentGrade("A+");

        // View the updated output
        controller.updateView();
    }
}