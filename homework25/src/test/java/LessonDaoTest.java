import entity.Homework;
import entity.Lesson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import enums.DataBaseConnection;
import repository.LessonDao;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LessonDaoTest {

    private LessonDao lessonDao;
    private DataBaseConnection dbConnection;

    private String updatedAtString;

    @BeforeEach
    public void setUp() {
        dbConnection = new DataBaseConnection();
        lessonDao = new LessonDao(dbConnection);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        updatedAtString = LocalDateTime.now().format(formatter);
    }

    @Test
    @Order(1)
    void testAddLesson() {
        Lesson lesson = Lesson.builder()
                .id(20)
                .name("Lesson 1")
                .updatedAt(updatedAtString)
                .homework(Homework.builder().id(1).build())
                .build();

        lessonDao.addLesson(lesson);

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM Lesson WHERE id = ?")
        ) {
            statement.setInt(1, lesson.getId());
            ResultSet resultSet = statement.executeQuery();
            Assertions.assertTrue(resultSet.next(), "Lesson record should exist in the database");

            System.out.println("Lesson added successfully");
        } catch (SQLException e) {
            e.printStackTrace();
            Assertions.fail("Exception occurred while checking lesson record in the database");
        }
    }

    @Test
    @Order(3)
    void testDeleteLesson() {
        int lessonId = 21;

        lessonDao.deleteLesson(lessonId);
        Lesson deletedLesson = lessonDao.getLessonById(lessonId);
        assertNull(deletedLesson);
    }

    @Test
    @Order(2)
    void testGetAllLessons() {
        Lesson lesson1 = Lesson.builder()
                .id(21)
                .name("Lesson 2")
                .updatedAt(updatedAtString)
                .homework(Homework.builder().id(2).build())
                .build();

        Lesson lesson2 = Lesson.builder()
                .id(22)
                .name("Lesson 3")
                .updatedAt(updatedAtString)
                .homework(Homework.builder().id(3).build())
                .build();


        lessonDao.addLesson(lesson1);
        lessonDao.addLesson(lesson2);

        List<Lesson> lessons = lessonDao.getAllLessons();

        assertNotNull(lessons);
        assertEquals(2, lessons.size());
        assertTrue(lessons.contains(lesson1));
        assertTrue(lessons.contains(lesson2));
    }

    @Test
    void testGetLessonById() {
        Lesson lesson = Lesson.builder()
                .id(23)
                .name("Lesson 4")
                .updatedAt(updatedAtString)
                .homework(Homework.builder().id(4).build())
                .build();

        lessonDao.addLesson(lesson);

        Lesson retrievedLesson = lessonDao.getLessonById(lesson.getId());

        assertNotNull(retrievedLesson);
        assertEquals(lesson.getId(), retrievedLesson.getId());
        assertEquals(lesson.getName(), retrievedLesson.getName());
        assertEquals(lesson.getUpdatedAt(), retrievedLesson.getUpdatedAt());
        assertEquals(lesson.getHomework().getId(), retrievedLesson.getHomework().getId());
        System.out.println("Retrieved Lesson:");
        System.out.println(retrievedLesson);
    }
}
