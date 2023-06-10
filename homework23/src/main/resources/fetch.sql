-- Получение всех записей из таблицы Homework
SELECT * FROM Homework;

-- Получение всех записей из таблицы Lesson, включая данные из таблицы Homework
SELECT Lesson.*, Homework.*
FROM Lesson
JOIN Homework ON Lesson.homework_id = Homework.id;

-- Получение всех записей из таблицы Lesson, включая данные из таблицы Homework, отсортированных по времени обновления
SELECT Lesson.*, Homework.*
FROM Lesson
JOIN Homework ON Lesson.homework_id = Homework.id
ORDER BY Lesson.updatedAt;

-- Получение всех записей из таблицы Schedule, включая данные из таблицы Lesson
SELECT Schedule.*, Lesson.*
FROM Schedule
JOIN ScheduleLesson ON Schedule.id = ScheduleLesson.schedule_id
JOIN Lesson ON ScheduleLesson.lesson_id = Lesson.id;

-- Получение количества Lesson для каждого Schedule
SELECT Schedule.id, Schedule.name, COUNT(Lesson.id) AS lesson_count
FROM Schedule
JOIN ScheduleLesson ON Schedule.id = ScheduleLesson.schedule_id
JOIN Lesson ON ScheduleLesson.lesson_id = Lesson.id
GROUP BY Schedule.id, Schedule.name;


