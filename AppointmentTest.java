/*
 * Copyright 2024 Stanislav Kovalchuk
 */

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.Calendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AppointmentTest {
	

	protected String fiftyCharAptDesc;
	protected String shortAptDesc;
	protected String longAptDesc;
	
	protected Date aptDateTest;
	protected Date pastAptDateTest;
	
	protected String shortID;
	protected String longAptID;
	protected String tenCharAptID;
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	void setUp() {
		shortID = "123";
		tenCharAptID = "1234567890";
		longAptID = "1234567890000";
		
		shortAptDesc = "Lorem ipsum dolor sit amet, consectetur";
		fiftyCharAptDesc = "Lorem ipsum dolor sit amet, consectetur lorem ipsu";
		longAptDesc = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed";
		
		aptDateTest = new Date(2024, Calendar.MAY, 9);
		pastAptDateTest = new Date(0);
	}
	
	@Test
	@DisplayName("Test Appointment ID")
	void AppointmentTestID() {
		Appointment appointment = new Appointment(shortAptDesc, aptDateTest);
		
		
		//less than 10 char test
		appointment.setID(shortID);
		assertAll("Appointment ID",
				()-> assertEquals(shortID, appointment.getID()));
		
		//10 char test, null and more than 10 char test
		appointment.setID(tenCharAptID);
		assertAll("Appointment ID",
				()-> assertEquals(tenCharAptID, appointment.getID()),
		        ()-> assertThrows(IllegalArgumentException.class, () -> appointment.setID(null)),
		        ()-> assertThrows(IllegalArgumentException.class, () -> appointment.setID(longAptID)));
	}
	
	
	@Test
	@DisplayName("Test Appointment description")
	void AppointmentTestDesc() {
		Appointment appointment = new Appointment(shortAptDesc, aptDateTest);
		
		//less than 50 char test
		assertAll("Appointment ID",
				()-> assertEquals(shortAptDesc, appointment.getDescription()));
		
		//50 char test, null and more than 50 char test
		appointment.setDescription(fiftyCharAptDesc);
		assertAll("Appointment Description",
		        ()-> assertEquals(fiftyCharAptDesc, appointment.getDescription()),
		        ()-> assertThrows(IllegalArgumentException.class, () -> appointment.setDescription(null)),
		        ()-> assertThrows(IllegalArgumentException.class, () -> appointment.setDescription(longAptDesc)));
	}
	
	@Test
	@DisplayName("Test Appointment date")
	void AppointmentTestDate() {
		Appointment appointment = new Appointment(shortAptDesc, aptDateTest);
		assertAll("Appointment Date",
		        ()-> assertEquals(aptDateTest, appointment.getDate()),
		        ()-> assertThrows(IllegalArgumentException.class, () -> appointment.setDate(null)),
		        ()-> assertThrows(IllegalArgumentException.class, () -> appointment.setDate(pastAptDateTest)));
	}
}