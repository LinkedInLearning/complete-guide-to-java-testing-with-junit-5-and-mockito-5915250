package com.linkedin.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TaskManagerTest {

  @Test
  public void addTask() {
    TaskManager taskManger = new TaskManager();
    Task task = new Task();

    taskManger.add(task);

    assertTrue(taskManger.exists(task.getId()));
  }

  @Test
  public void addTask_duplicateTasks() {
    TaskManager taskManager = new TaskManager();
    Task task1 = new Task();
    Task task2 = new Task();

    taskManager.add(task1);
    taskManager.add(task2);
    assertTrue(taskManager.exists(task1.getId()));
    assertTrue(taskManager.exists(task2.getId()));
    assertEquals(2, taskManager.count());
  }
}
