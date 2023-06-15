-- Создание таблицы Homework
CREATE TABLE Homework (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255),
  description VARCHAR(255)
);

-- Создание таблицы Lesson
CREATE TABLE Lesson (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255),
  updatedAt VARCHAR(45),
  homework_id INT,
  FOREIGN KEY (homework_id) REFERENCES Homework (id)
);

-- Создание таблицы Schedule
CREATE TABLE Schedule (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255),
  updatedAt VARCHAR(45)
);

-- Создание связующей таблицы ScheduleLesson
CREATE TABLE ScheduleLesson (
  schedule_id INT,
  lesson_id INT,
  PRIMARY KEY (schedule_id, lesson_id),
  FOREIGN KEY (schedule_id) REFERENCES Schedule (id),
  FOREIGN KEY (lesson_id) REFERENCES Lesson (id)
);