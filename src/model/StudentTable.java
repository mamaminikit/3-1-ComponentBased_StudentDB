package model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/*
 * @mmmaimankarae
 */

public class StudentTable {
    public static void insertStudent(Student stu) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("studentPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(stu);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    public static void updateStudent(Student stu) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("studentPU");
        EntityManager em = emf.createEntityManager();
        Student fromDb = em.find(Student.class, stu.getId());
        fromDb.setName(stu.getName());
        fromDb.setGpa(stu.getGpa());
        em.getTransaction().begin();
        try {
            em.persist(fromDb);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    public static Student findStudentById(Integer id) {
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("studentPU");
        EntityManager em = emf.createEntityManager();
        Student stu = em.find(Student.class, id);
        em.close();
        return stu;
    }
    
    public static List<Student> findAllStudent() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("studentPU");
        EntityManager em = emf.createEntityManager();
        List<Student> stuList = (List<Student>) em.createNamedQuery("Student.findAll").getResultList();
        em.close();
        return stuList;
    }
    
    public static List<Student> findStudentByName(String name) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("studentPU");
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Student.findByName");
        query.setParameter("name", name);
        List<Student> empList = (List<Student>) query.getResultList();
        em.close();
        return empList;
    }
    
    public static void removeStudent(Student stu) {
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("studentPU");
        EntityManager em = emf.createEntityManager();
        Student fromDb = em.find(Student.class, stu.getId());
        em.getTransaction().begin();
        try {
            em.remove(fromDb);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }           
    }
}
