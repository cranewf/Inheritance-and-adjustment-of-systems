package ru.netology.task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TodosTest {
    SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

    String[] subtasks = {"Молоко", "Яйца", "Хлеб", "Выкатка 3й версии приложения"};
    Epic epic = new Epic(55, subtasks);

    Meeting meeting = new Meeting(
            555,
            "Выкатка 3й версии приложения",
            "Приложение НетоБанка",
            "Во вторник после обеда"
    );

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void giveMeATaskWithSimpleTask() {

        Todos search = new Todos();
        search.add(simpleTask);
        search.add(epic);
        search.add(meeting);

        Task[] expected = {simpleTask};
        Task[] actual = search.search("Позвонить родителям");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void giveMeSearchAllTasks() {
        Todos search = new Todos();
        search.add(simpleTask);
        search.add(epic);
        search.add(meeting);

        Task[] actual1 = search.search("Позвонить родителям");
        Task[] actual2 = search.search("Яйца");
        Task[] actual3 = search.search("Приложение НетоБанка");

        Task[] expected = {simpleTask, epic, meeting};
        Task[][] actual = {actual1, actual2, actual3};
    }

    @Test
    public void giveMeSearchNoteTasks() {
        Todos search = new Todos();
        search.add(simpleTask);
        search.add(epic);
        search.add(meeting);

        Task[] expected = {};
        Task[] actual = search.search("Вода");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void giveMeSearchMultipleTasks() {
        Todos search = new Todos();
        search.add(simpleTask);
        search.add(epic);
        search.add(meeting);

        Task[] expected = {epic, meeting};
        Task[] actual = search.search("Выкатка 3й версии приложения");

        Assertions.assertArrayEquals(expected, actual);

    }


}