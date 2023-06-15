package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Lesson {

    private int id;
    private String name;
    private String updatedAt;
    private Homework homework;

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", homeworkId=" + homework.getId() +
                '}';
    }
}