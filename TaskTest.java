/*
 * Copyright 2024 Stanislav Kovalchuk
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TaskTest {
	
	protected String shortID, tenCharID, longID;
	protected String shortTaskName, twentyCharTaskName, shortTaskDesc, fiftyCharTaskDesc;
	protected String longTaskName, longTaskDesc;

	
	@BeforeEach
	void setUp() {
		shortID = "1";
		tenCharID = "1234567890";
		longID = "1234567890000";
		
		shortTaskName = "Lorem Ipsum";
		twentyCharTaskName = "Lorem Ipsum Lorem Ip";
		longTaskName = "Lorem ipsum dolor sit amet, consectetur";
		
		
		shortTaskDesc = "Lorem ipsum dolor sit amet";
		fiftyCharTaskDesc = "Lorem ipsum dolor sit amet Lorem ipsum dolor sit a";
		longTaskDesc = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed";
	}

	
	
	
	@Test
	@DisplayName("Test task ID")
	void TestTaskId() {
		Task task = new Task(shortTaskName, shortTaskDesc);
		
		//less than 10 char test
		task.setID(shortID);
		assertAll("Task ID",
				()-> assertEquals(shortID, task.getTaskID()));
				
		//10 char test, null and more than 10 char test
		task.setID(tenCharID);
		assertAll("Task ID",
				()-> assertEquals(tenCharID, task.getTaskID()),
		        ()-> assertThrows(IllegalArgumentException.class, () -> task.setID(null)),
		        ()-> assertThrows(IllegalArgumentException.class, () -> task.setID(longID)));		

		
	}

	@Test
	@DisplayName("Test task name")
	void TestTaskName() {
		Task task = new Task(shortTaskName, shortTaskDesc); 
		
		//less than 20 char test
		assertAll("Task Name",
				()-> assertEquals(shortTaskName, task.getTaskName()));
		
		//20 char test, null and more than 20 char test
		task.setTaskName(twentyCharTaskName);
		assertAll("Task Name",
		        ()-> assertEquals(twentyCharTaskName, task.getTaskName()),
		        ()-> assertThrows(IllegalArgumentException.class, () -> task.setTaskName(null)),
		        ()-> assertThrows(IllegalArgumentException.class, () -> task.setTaskName(longTaskName)));
		
	}


	@Test
	@DisplayName("Test task description")
	void TestTaskDesc() {
		Task task = new Task(shortTaskName, shortTaskDesc); 
		
		//less than 50 char test
		assertAll("Task Description",
				()-> assertEquals(shortTaskDesc, task.getTaskDesc()));
		
		//50 char test, null and more than 50 char test
		task.setTaskDesc(fiftyCharTaskDesc);
		assertAll("Task Description",
		        ()-> assertEquals(fiftyCharTaskDesc, task.getTaskDesc()),
		        ()-> assertThrows(IllegalArgumentException.class, () -> task.setTaskDesc(null)),
		        ()-> assertThrows(IllegalArgumentException.class, () -> task.setTaskDesc(longTaskDesc)));
	}
}
