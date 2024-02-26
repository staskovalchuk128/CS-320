/*
 * Copyright 2024 Stanislav Kovalchuk
 */

import java.util.concurrent.atomic.AtomicLong;

public class Task {
	
	private static final int TASK_ID_LEN = 10, TASK_NAME_LEN = 20, TASK_DESC_LEN = 50;
	
	private String taskID;
	private String taskName;
	private String taskDesc;
	private static AtomicLong idGenerator = new AtomicLong();
	
	public Task() {

		this.taskID = String.valueOf(idGenerator.getAndIncrement());
	}
	
	
	public Task(String taskName, String taskDesc) {

		this.taskID = String.valueOf(idGenerator.getAndIncrement());
		
		setTaskName(taskName);
		setTaskDesc(taskDesc);
	}
	

	public String getTaskID() {
		return taskID;
	}
	
	public String getTaskName() {
		return taskName;
	}
	
	public String getTaskDesc() {
		return taskDesc;
	}
	

	public void setID(String newId) {
		if (newId == null || newId.isEmpty()) {
			throw new IllegalArgumentException("Task ID can't be empty");
		} else if (newId.length() > TASK_ID_LEN) {
			throw new IllegalArgumentException("Task ID can't be longer than " +
					TASK_ID_LEN + " characters");
		} else {
			taskID = newId;
		}
	}

	public void setTaskName(String taskName) {
		if (taskName == null || taskName.isEmpty()) {
			throw new IllegalArgumentException("Task Name can't be empty");
		} else if (taskName.length() > TASK_NAME_LEN) {
			throw new IllegalArgumentException("Task Name can't be longer than " +
												TASK_NAME_LEN + " characters");
		} else {
			this.taskName = taskName;
		}
	}
	
	public void setTaskDesc(String taskDesc) {
		if (taskDesc == null || taskDesc.isEmpty()) {
			throw new IllegalArgumentException("Task Description can't be empty");
		} else if (taskDesc.length() > TASK_DESC_LEN) {
			throw new IllegalArgumentException("Task Description can't be longer than " +
					TASK_DESC_LEN + " characters");
		} else {
			this.taskDesc = taskDesc;
		}
	}
}
