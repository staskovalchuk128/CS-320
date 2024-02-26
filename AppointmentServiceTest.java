/*
 * Copyright 2024 Stanislav Kovalchuk
 */

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;


class AppointmentServiceTest {

	protected String aptDescTest;
	protected String longAptDesc;
	
	protected Date aptDateTest;
	protected Date pastAptDateTest;
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	void setUp() {
		aptDescTest = "Lorem ipsum dolor sit amet, consectetur";
		longAptDesc = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed";
		
		aptDateTest = new Date(2024, Calendar.MAY, 9);
		pastAptDateTest = new Date(0);
	}
	
	
	@Test
	@DisplayName("Test Update appointment description.")
	@Order(1)
	void testUpdateAppointmentDesc() {
		AppointmentService service = new AppointmentService();
		String appointmentID = service.addAppointment("desc", aptDateTest);
		service.updateAppointmentDesc(aptDescTest, appointmentID);
		
		
		assertAll("Appointment Description",
		        ()-> assertEquals(aptDescTest, service.getAppointment(appointmentID).getDescription()),
		        ()-> assertThrows(IllegalArgumentException.class, () -> service.updateAppointmentDesc(null, appointmentID)),
		        ()-> assertThrows(IllegalArgumentException.class, () -> service.updateAppointmentDesc(longAptDesc, appointmentID)));
		
	}
	
	
	@Test
	@DisplayName("Test Update appointment date")
	@Order(2)
	void testUpdateAppointmentDate() {
		AppointmentService service = new AppointmentService();
		@SuppressWarnings("deprecation")
		String appointmentID = service.addAppointment(aptDescTest,  new Date(2026, Calendar.FEBRUARY, 15));
		service.updateAppointmentDate(aptDateTest, appointmentID);

		assertAll("Appointment Date",
		        ()-> assertEquals(aptDateTest, service.getAppointment(appointmentID).getDate()),
		        ()-> assertThrows(IllegalArgumentException.class, () -> service.updateAppointmentDate(null, appointmentID)),
		        ()-> assertThrows(IllegalArgumentException.class, () -> service.updateAppointmentDate(pastAptDateTest, appointmentID)));
	}

	

	@Test
	@DisplayName("Test to ensure that service correctly deletes appointments.")
	@Order(3)
	void testDeleteAppointment() {
		AppointmentService service = new AppointmentService();
		String appointmentID = service.addAppointment(aptDescTest, aptDateTest);
		service.deleteAppointment(appointmentID);
		
		ArrayList<Appointment> appointmentListEmpty = new ArrayList<Appointment>();
		service.displayAppointmentList();
		assertEquals(service.appointmentList, appointmentListEmpty, "The appointment was not deleted.");
	}

	@Test
	@DisplayName("Test to ensure that service can add an appointment.")
	@Order(4)
	void testAddAppointment() {
		AppointmentService service = new AppointmentService();
		String appointmentID = service.addAppointment(aptDescTest, aptDateTest);
		service.displayAppointmentList();
		assertNotNull(service.getAppointment(appointmentID), "Appointment was not added.");
	}
}