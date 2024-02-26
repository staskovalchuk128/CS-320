/*
 * Copyright 2024 Stanislav Kovalchuk
 */

import java.util.concurrent.atomic.AtomicLong;
import java.util.Date;

public class Appointment {
	private static final int APT_ID_LEN = 10, APT_DESC_LEN = 50;
	
	private String appointmentID;
	private Date appointmentDate;
	private String appointmentDesc;
	private static AtomicLong idGenerator = new AtomicLong();
	
	
	public Appointment() {
		this.appointmentID = String.valueOf(idGenerator.getAndIncrement());
	}

	public Appointment(String appointmentDesc, Date appointmentDate) {

		this.appointmentID = String.valueOf(idGenerator.getAndIncrement());
		
		setDate(appointmentDate);
		setDescription(appointmentDesc);
	}
	
	public String getID() {
		return appointmentID;
	}
	
	public Date getDate() {
		return appointmentDate;
	}
	
	public String getDescription() {
		return appointmentDesc;
	}
	
	public void setID(String newId) {
		if (newId == null || newId.isEmpty()) {
			throw new IllegalArgumentException("Appointment ID can't be empty");
		} else if (newId.length() > APT_ID_LEN) {
			throw new IllegalArgumentException("Appointment ID can't be longer than " +
					APT_ID_LEN + " characters");
		} else {
			appointmentID = newId;
		}
	}
	
	public void setDate(Date date) {
		if (date == null) {
			throw new IllegalArgumentException("Appointment date can't be empty");
		} else if (date.before(new Date())) {
			throw new IllegalArgumentException("Cannot make appointment before current date.");
		} else {
			appointmentDate = date;
		}
	}
	
	public void setDescription(String desc) {
		
		if (desc == null || desc.isEmpty()) {
			throw new IllegalArgumentException("Appointment Description can't be empty");
		} else if (desc.length() > APT_DESC_LEN) {
			throw new IllegalArgumentException("Appointment Description can't be longer than " +
					APT_DESC_LEN + " characters");
		} else {
			appointmentDesc = desc;
		}
		
	}
}