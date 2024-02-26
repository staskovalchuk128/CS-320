/*
 * Copyright 2024 Stanislav Kovalchuk
 */

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class TaskServiceTest {
	
	@Test
	@DisplayName("Test to Update task name")
	@Order(1)
	void testUpdateTaskName() {
		TaskService service = new TaskService();
		service.addTask("Task Name", "Description");
		service.updateTaskName("Updated Task Name", "3");
		service.displayTaskList();
		assertEquals("Updated Task Name", service.getTask("3").getTaskName(), "Task name is not updated.");
	}

	@Test
	@DisplayName("Test to Update task description.")
	@Order(2)
	void testUpdateTaskDesc() {
		TaskService service = new TaskService();
		service.addTask("Task Name", "Description");
		service.updateTaskDesc("Updated Description", "1");
		service.displayTaskList();
		assertEquals("Updated Description", service.getTask("1").getTaskDesc(), "Task description is not updated.");
	}

	@Test
	@DisplayName("Test to ensure that service correctly deletes tasks.")
	@Order(5)
	void testDeleteContact() {
		TaskService service = new TaskService();
		service.addTask("Task Name", "Description");
		service.deleteTask("0");
	
		ArrayList<Task> taskListEmpty = new ArrayList<Task>();
		service.displayTaskList();
		assertEquals(service.taskList, taskListEmpty, "The contact is not deleted.");
	}

	@Test
	@DisplayName("Test to ensure that service can add a task.")
	@Order(6)
	void testAddContact() {
		TaskService service = new TaskService();
		service.addTask("Task Name", "Description");
		service.displayTaskList();
		assertNotNull(service.getTask("0"), "Task is not added correctly.");
	}
}
