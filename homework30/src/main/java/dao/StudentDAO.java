package dao;

import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import enums.HibernateUtil;

import java.util.List;
import java.util.function.Consumer;

public class StudentDAO {

    private void executeWithSession(Consumer<Session> action) {
        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            action.accept(session);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addStudent(Student student) {
        executeWithSession(session -> {
            session.persist(student);
            session.flush();
            session.refresh(student);
        });
    }

    public void updateStudent(Student student) {
        executeWithSession(session -> session.merge(student));
    }

    public void deleteStudent(Student student) {
        executeWithSession(session -> session.remove(student));
    }

    public Student getStudentById(int id) {
        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {
            return session.get(Student.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Student> getAllStudents() {
        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {
            return session.createQuery("FROM Student", Student.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}