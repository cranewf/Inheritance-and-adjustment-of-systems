package ru.netology.task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaskTest {
    SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

    String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
    Epic epic = new Epic(55, subtasks);

    Meeting meeting = new Meeting(
            555,
            "Выкатка 3й версии приложения",
            "Приложение НетоБанка",
            "Во вторник после обеда"
    );

    @Test
    public void giveMeAllTasks() {
        boolean searchSimple = simpleTask.matches("Позвонить родителям");
        boolean searchEpic = epic.matches("Хлеб");
        boolean searchMeeting = meeting.matches("Приложение НетоБанка");

        Assertions.assertTrue(searchSimple);
        Assertions.assertTrue(searchEpic);
        Assertions.assertTrue(searchMeeting);
    }


    @Test
    public void dontGiveMeTasksAllTasks() {
        boolean searchSimple = simpleTask.matches("Позвонить брату");
        boolean searchEpic = epic.matches("Соль");
        boolean searchMeeting = meeting.matches("Приложение НетБанка");

        Assertions.assertFalse(searchSimple);
        Assertions.assertFalse(searchEpic);
        Assertions.assertFalse(searchMeeting);
    }

}
