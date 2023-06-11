package repository;

import entity.Homework;
import entity.Lesson;
import enums.DataBaseConnection;
import lombok.SneakyThrows;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class LessonDao implements LessonRepository {
    private final DataBaseConnection dbConnection;

    public LessonDao(DataBaseConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @SneakyThrows
    public void addLesson(Lesson lesson) {
        String query = "INSERT INTO Lesson (id, name, updatedAt, homework_id) VALUES (?, ?, ?, ?)";

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)
        ) {
            statement.setInt(1, lesson.getId());
            statement.setString(2, lesson.getName());
            statement.setString(3, lesson.getUpdatedAt());
            statement.setInt(4, lesson.getHomework().getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteLesson(int lessonId) {
        String query = "DELETE FROM Lesson WHERE id = ?";

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)
        ) {
            statement.setInt(1, lessonId);

            int rowsDeleted = statement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Lesson deleted successfully");
            } else {
                System.out.println("Lesson not found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Lesson> getAllLessons() {
        String query = "SELECT * FROM Lesson";
        List<Lesson> lessons = new ArrayList<>();

        try (Connection connection = dbConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)
        ) {
            while (resultSet.next()) {
                lessons.add(buildLessonFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lessons;
    }

    @Override
    public Lesson getLessonById(int lessonId) {
        String query = "SELECT l.id, l.name, l.updatedAt, h.id AS homework_id " +
                "FROM Lesson l " +
                "JOIN Homework h ON l.homework_id = h.id " +
                "WHERE l.id = ?";
        Lesson lesson = null;

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)
        ) {
            statement.setInt(1, lessonId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    lesson = buildLessonFromResultSet(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lesson;
    }

    private Lesson buildLessonFromResultSet(ResultSet resultSet) throws SQLException {
        return Lesson.builder()
                .id(resultSet.getInt("id"))
                .name(resultSet.getString("name"))
                .updatedAt(resultSet.getString("updatedAt"))
                .homework(Homework.builder().id(resultSet.getInt("homework_id")).build())
                .build();
    }
}
