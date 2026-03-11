package org.example;


import org.example.dao.StudentDAO;
import org.example.dao.StudentDAOImpl;
import org.example.entity.Student;

import java.util.List;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        StudentDAO dao = new StudentDAOImpl();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== STUDENT MANAGEMENT =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Fetch By ID");
            System.out.println("4. Update Marks");
            System.out.println("5. Delete Student");
            System.out.println("6. Sort By Marks");
            System.out.println("7. Sort By Age Desc");
            System.out.println("8. Filter By Department");
            System.out.println("9. Native Fetch");
            System.out.println("10. Native Update Marks");
            System.out.println("0. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    sc.nextLine(); // clear buffer
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Department: ");
                    String dept = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();

                    System.out.print("Enter Marks: ");
                    double marks = sc.nextDouble();

                    Student student = new Student(name, dept, age, marks);
                    dao.save(student);

                    System.out.println("Student Added Successfully!");
                    break;

                case 2:
                    List<Student> students = dao.fetchAll();
                    students.forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();

                    Student s = dao.fetchById(id);
                    System.out.println(s != null ? s : "Student Not Found");
                    break;

                case 4:
                    System.out.print("Enter ID: ");
                    int updateId = sc.nextInt();

                    System.out.print("Enter New Marks: ");
                    double newMarks = sc.nextDouble();

                    dao.updateMarks(updateId, newMarks);
                    System.out.println("Marks Updated Successfully!");
                    break;

                case 5:
                    System.out.print("Enter ID: ");
                    int deleteId = sc.nextInt();

                    dao.delete(deleteId);
                    System.out.println("Student Deleted Successfully!");
                    break;

                case 6:
                    List<Student> sortedMarks = dao.sortByMarks();
                    sortedMarks.forEach(System.out::println);
                    break;

                case 7:
                    List<Student> sortedAge = dao.sortByAgeDesc();
                    sortedAge.forEach(System.out::println);
                    break;

                case 8:
                    sc.nextLine();
                    System.out.print("Enter Department: ");
                    String filterDept = sc.nextLine();

                    List<Student> filtered = dao.filterByDept(filterDept);
                    filtered.forEach(System.out::println);
                    break;

                case 9:
                    List<Student> nativeList = dao.nativeFetch();
                    nativeList.forEach(System.out::println);
                    break;

                case 10:
                    System.out.print("Enter ID: ");
                    int nid = sc.nextInt();

                    System.out.print("Enter New Marks: ");
                    double nmarks = sc.nextDouble();

                    dao.nativeUpdateMarks(nid, nmarks);
                    System.out.println("Marks Updated Using Native Query!");
                    break;

                case 0:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
