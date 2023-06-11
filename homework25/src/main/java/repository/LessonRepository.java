package repository;

import entity.Lesson;

import java.sql.SQLException;
import java.util.List;

public interface LessonRepository {
    void addLesson(Lesson lesson) throws SQLException;
    void deleteLesson(int lessonId);
    List<Lesson> getAllLessons();
    Lesson getLessonById(int lessonId);
}
