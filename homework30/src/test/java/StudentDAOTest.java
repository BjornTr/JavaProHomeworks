import dao.StudentDAO;
import entity.Student;
import enums.HibernateUtil;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StudentDAOTest {

    private StudentDAO studentDAO;

    @BeforeEach
    public void setUp() {
        studentDAO = new StudentDAO();
    }

    @Test
    public void testAddStudent() {
        Student student = new Student();
        student.setName("John Bae2");
        student.setEmail("john@example.com");

        studentDAO.addStudent(student);

        Student addedStudent = studentDAO.getStudentById(student.getId());

        assertNotNull(addedStudent);
        assertEquals(student.getId(), addedStudent.getId());
        assertEquals("John Bae2", addedStudent.getName());
        assertEquals("john@example.com", addedStudent.getEmail());

        System.out.println("Added Student: " + addedStudent);
    }

    @Test
    public void testUpdateStudent() {
        Student student = studentDAO.getStudentById(1);
        assertNotNull(student);

        student.setEmail("john.doe@example.com");

        studentDAO.updateStudent(student);

        Student updatedStudent = studentDAO.getStudentById(1);

        assertNotNull(updatedStudent);
        assertEquals("john.doe@example.com", updatedStudent.getEmail());

        System.out.println("Updated Student: " + updatedStudent);
    }

    @Test
    public void testDeleteStudent() {
        Student student = studentDAO.getStudentById(15);
        assertNotNull(student);

        studentDAO.deleteStudent(student);

        Student deletedStudent = studentDAO.getStudentById(15);

        assertNull(deletedStudent);

        System.out.println("Deleted Student: " + student);
    }

    @Test
    public void testGetStudentById() {
        Student existingStudent = studentDAO.getStudentById(1);
        assertNotNull(existingStudent);

        System.out.println("ID: " + existingStudent.getId());
        System.out.println("Name: " + existingStudent.getName());
        System.out.println("Email: " + existingStudent.getEmail());

        assertEquals(1, existingStudent.getId());
        assertEquals("John Doe", existingStudent.getName());
        assertEquals("john.doe@example.com", existingStudent.getEmail());
    }

    @Test
    public void testGetAllStudents() {
        List<Student> students = studentDAO.getAllStudents();
        assertNotNull(students);
        assertFalse(students.isEmpty());

        for (Student student : students) {
            System.out.println(student);
        }
    }

    @AfterAll
    public static void tearDown() {
        HibernateUtil.INSTANCE.shutdown();
    }
}
