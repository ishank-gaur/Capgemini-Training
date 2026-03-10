package org.example.dao;



import org.example.entity.Laptop;
import org.example.entity.Student1;
import org.example.repository.repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class StudentDaoImpl implements StudentDao {

    @Override
    public void saveData() {

        EntityManager em = repository.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Laptop laptop = new Laptop();
        laptop.setBrand("HP");
        laptop.setPrice(65000);

        Student1 student = new Student1();
        student.setName("Ishank");
        student.setCourse("Full Stack");

        // Setting relationship (VERY IMPORTANT)
        student.setLaptop(laptop);
        laptop.setStudent(student);

        em.persist(laptop);
        em.persist(student);

        tx.commit();
        em.close();

        System.out.println("Data Saved Successfully");
    }

    @Override
    public void fetchLaptopFromStudent(int studentId) {

        EntityManager em = repository.getEntityManager();

        Student1 student = em.find(Student1.class, studentId);

        if (student != null && student.getLaptop() != null) {
            Laptop laptop = student.getLaptop();
            System.out.println("Brand: " + laptop.getBrand());
            System.out.println("Price: " + laptop.getPrice());
        } else {
            System.out.println("Student or Laptop not found");
        }

        em.close();
    }

    @Override
    public void fetchStudentFromLaptop(int laptopId) {

        EntityManager em = repository.getEntityManager();

        Laptop laptop = em.find(Laptop.class, laptopId);

        if (laptop != null && laptop.getStudent() != null) {
            Student1 student = laptop.getStudent();
            System.out.println("Name: " + student.getName());
            System.out.println("Course: " + student.getCourse());
        } else {
            System.out.println("Laptop or Student not found");
        }

        em.close();
    }

    @Override
    public void updateLaptopBrand(int laptopId, String newBrand) {

        EntityManager em = repository.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Laptop laptop = em.find(Laptop.class, laptopId);

        if (laptop != null) {
            laptop.setBrand(newBrand);
            System.out.println("Laptop Brand Updated");
        } else {
            System.out.println("Laptop not found");
        }

        tx.commit();
        em.close();
    }

    @Override
    public void updateStudentCourse(int studentId, String newCourse) {

        EntityManager em = repository.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Student1 student = em.find(Student1.class, studentId);

        if (student != null) {
            student.setCourse(newCourse);
            System.out.println("Student Course Updated");
        } else {
            System.out.println("Student not found");
        }

        tx.commit();
        em.close();
    }

    @Override
    public void changeLaptopForStudent(int studentId) {
        EntityManager em = repository.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Student1 student = em.find(Student1.class, studentId);

        if (student != null) {

            // Get old laptop
            Laptop oldLaptop = student.getLaptop();

            // Create NEW laptop with default values
            Laptop newLaptop = new Laptop();
            newLaptop.setBrand("Default Brand");
            newLaptop.setPrice(50000);

            // Persist new laptop first
            em.persist(newLaptop);

            // Set new relationship
            student.setLaptop(newLaptop);
            newLaptop.setStudent(student);

            // Remove old laptop
            if (oldLaptop != null) {
                oldLaptop.setStudent(null);
                em.remove(oldLaptop);
            }

            System.out.println("New default laptop assigned and old laptop deleted");

        } else {
            System.out.println("Student not found");
        }

        tx.commit();
        em.close();
    }
    @Override
    public void removeLaptopFromStudent(int studentId) {

        EntityManager em = repository.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Student1 student = em.find(Student1.class, studentId);

        if (student != null && student.getLaptop() != null) {

            Laptop laptop = student.getLaptop();

            // Break relationship
            student.setLaptop(null);
            laptop.setStudent(null);

            // Remove laptop from table
            em.remove(laptop);

            System.out.println("Laptop removed and deleted from table");

        } else {
            System.out.println("Student or Laptop not found");
        }

        tx.commit();
        em.close();
    }

    @Override
    public void deleteStudentAndLaptop(int studentId) {

        EntityManager em = repository.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Student1 student = em.find(Student1.class, studentId);

        if (student != null) {

            Laptop laptop = student.getLaptop();

            em.remove(student);

            if (laptop != null) {
                em.remove(laptop);
            }

            System.out.println("Student and Laptop Deleted");

        } else {
            System.out.println("Student not found");
        }

        tx.commit();
        em.close();
    }
}
