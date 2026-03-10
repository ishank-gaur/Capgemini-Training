package org.example;

import org.example.dao.StudentDao;
import org.example.dao.StudentDaoImpl;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentDao dao = new StudentDaoImpl();

        while (true) {

            System.out.println("\n===== JPA One-To-One Menu =====");
            System.out.println("1. Save Data");
            System.out.println("2. Fetch Laptop From Student");
            System.out.println("3. Fetch Student From Laptop");
            System.out.println("4. Update Laptop Brand");
            System.out.println("5. Update Student Course");
            System.out.println("6. Change Laptop For Student");
            System.out.println("7. Remove Laptop From Student");
            System.out.println("8. Delete Student And Laptop");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    dao.saveData();
                    break;

                case 2:
                    System.out.print("Enter Student ID: ");
                    int studentId1 = sc.nextInt();
                    dao.fetchLaptopFromStudent(studentId1);
                    break;

                case 3:
                    System.out.print("Enter Laptop ID: ");
                    int laptopId1 = sc.nextInt();
                    dao.fetchStudentFromLaptop(laptopId1);
                    break;

                case 4:
                    System.out.print("Enter Laptop ID: ");
                    int laptopId2 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter New Brand: ");
                    String newBrand = sc.nextLine();
                    dao.updateLaptopBrand(laptopId2, newBrand);
                    break;

                case 5:
                    System.out.print("Enter Student ID: ");
                    int studentId2 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter New Course: ");
                    String newCourse = sc.nextLine();
                    dao.updateStudentCourse(studentId2, newCourse);
                    break;

                case 6:
                    System.out.print("Enter Student ID: ");
                    int studentId3 = sc.nextInt();
                    dao.changeLaptopForStudent(studentId3);
                    break;

                case 7:
                    System.out.print("Enter Student ID: ");
                    int studentId4 = sc.nextInt();
                    dao.removeLaptopFromStudent(studentId4);
                    break;

                case 8:
                    System.out.print("Enter Student ID: ");
                    int studentId5 = sc.nextInt();
                    dao.deleteStudentAndLaptop(studentId5);
                    break;

                case 9:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
