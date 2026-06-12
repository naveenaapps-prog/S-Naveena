package studentManagementSystem;
import java.util.ArrayList;
import java.util.Scanner;

// Student class
class Student {
    private int rollNo;
    private String name;
    private double emarks;
    private double hmarks;
    private double mmarks;
    private double smarks;
    private double ssmarks;
    private double total;
    private double percentage;

    public Student(int rollNo, String name, double emarks, double hmarks, double mmarks, double smarks, double ssmarks, double total, double percentage) {
        this.rollNo = rollNo;
        this.name = name;
        this.emarks = emarks;
        this.hmarks = hmarks;
        this.mmarks = mmarks;
        this.smarks = smarks;
        this.ssmarks = ssmarks;
        this.total = total;
        this.percentage = percentage;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public double getEMarks() {
        return emarks;
    }
    
    public double getHMarks() {
        return hmarks;
    }
    
    public double getMMarks() {
        return mmarks;
    }
    
    public double getSMarks() {
        return smarks;
    }
    
    public double getSSMarks() {
        return ssmarks;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setEMarks(double emarks) {
        this.emarks = emarks;
    }

    public void setHMarks(double hmarks) {
        this.hmarks = hmarks;
    }
    
    public void setMMarks(double mmarks) {
        this.mmarks = mmarks;
    }
    
    public void setSMarks(double smarks) {
        this.smarks = smarks;
    }
    
    public void setSSMarks(double ssmarks) {
        this.ssmarks = ssmarks;
    }
    public void display() {
        System.out.println("Roll No: " + rollNo + ", Name: " + name + ", English Marks: " + emarks + ", Hindi Marks: " + hmarks + ", Maths marks: " + mmarks + ", Science marks: " + smarks + ", Social science marks: " + ssmarks + ", Total: " + total + ", Percentage: " + percentage);
    }
}

// Main class
public class StudentManagementSystem {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    // Add student
    public static void addStudent() {
        System.out.print("Enter Roll No: ");
        int rollNo = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter English Marks: ");
        double emarks = sc.nextDouble();
        System.out.print("Enter Hindi Marks: ");
        double hmarks = sc.nextDouble();
        System.out.print("Enter Maths Marks: ");
        double mmarks = sc.nextDouble();
        System.out.print("Enter Science Marks: ");
        double smarks = sc.nextDouble();
        System.out.print("Enter Social science Marks: ");
        double ssmarks = sc.nextDouble();
        
        double total = emarks + hmarks + mmarks + smarks + ssmarks;
        double percentage = (total / 500) * 100; 

        students.add(new Student(rollNo, name, emarks, hmarks, mmarks, smarks, ssmarks, total, percentage));
        System.out.println("Student added successfully!");
    }

    // Display all students
    public static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records found.");
        } else {
            System.out.println("\n--- Student Records ---");
            for (Student s : students) {
                s.display();
            }
        }
    }

    // Search student by roll number
    public static void searchStudent() {
        System.out.print("Enter Roll No to search: ");
        int rollNo = sc.nextInt();
        boolean found = false;

        for (Student s : students) {
            if (s.getRollNo() == rollNo) {
                System.out.println("Student Found:");
                s.display();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student with Roll No " + rollNo + " not found.");
        }
    }

    // Update student details
    public static void updateStudent() {
        System.out.print("Enter Roll No to update: ");
        int rollNo = sc.nextInt();
        sc.nextLine(); // consume newline
        boolean found = false;

        for (Student s : students) {
            if (s.getRollNo() == rollNo) {
                System.out.print("Enter new name: ");
                String name = sc.nextLine();
                System.out.print("Enter new English marks: ");
                double emarks = sc.nextDouble();
                System.out.print("Enter new Hindi marks: ");
                double hmarks = sc.nextDouble();
                System.out.print("Enter new Maths marks: ");
                double mmarks = sc.nextDouble();
                System.out.print("Enter new Science marks: ");
                double smarks = sc.nextDouble();
                System.out.print("Enter new Social science marks: ");
                double ssmarks = sc.nextDouble();

                s.setName(name);
                s.setEMarks(emarks);
                s.setHMarks(hmarks);
                s.setMMarks(mmarks);
                s.setSMarks(smarks);
                s.setSSMarks(ssmarks);
                System.out.println("Student details updated successfully!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student with Roll No " + rollNo + " not found.");
        }
    }

    // Delete student
    public static void deleteStudent() {
        System.out.print("Enter Roll No to delete: ");
        int rollNo = sc.nextInt();
        boolean removed = students.removeIf(s -> s.getRollNo() == rollNo);

        if (removed) {
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student with Roll No " + rollNo + " not found.");
        }
    }

    // Main menu
    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Student Record Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> displayStudents();
                case 3 -> searchStudent();
                case 4 -> updateStudent();
                case 5 -> deleteStudent();
                case 6 -> System.out.println("Exiting... Goodbye!");
                default -> System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 6);

        sc.close();
    }
}
