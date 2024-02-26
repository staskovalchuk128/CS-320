/*
 * Copyright 2024 Stanislav Kovalchuk
 */

import java.util.ArrayList;
import java.util.Date;

public class AppointmentService {
	public ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();

	public void displayAppointmentList() {
		for (int counter = 0; counter < appointmentList.size(); counter++) {
			System.out.println("\t Appointment ID: " + appointmentList.get(counter).getID());
			System.out.println("\t Appointment Date: " + appointmentList.get(counter).getDate());
			System.out.println("\t Appointment Description: " + appointmentList.get(counter).getDescription());
		}
	}

	public String addAppointment(String desc, Date date) {
		Appointment appointment = new Appointment(desc, date);
		appointmentList.add(appointment);
		return appointment.getID();
	}


	public Appointment getAppointment(String appointmentID) {
		Appointment appointment = new Appointment();
		for (int counter = 0; counter < appointmentList.size(); counter++) {
			if (appointmentList.get(counter).getID().contentEquals(appointmentID)) {
				appointment = appointmentList.get(counter);
			}
		}
		return appointment;
	}

	public void deleteAppointment(String appointmentID) {
		for (int counter = 0; counter < appointmentList.size(); counter++) {
			if (appointmentList.get(counter).getID().equals(appointmentID)) {
				appointmentList.remove(counter);
				break;
			}
			if (counter == appointmentList.size() - 1) {
				System.out.println("Appointment with ID: " + appointmentID + " not found.");
			}
		}
	}

	public void updateAppointmentDate(Date updatedDate, String appointmentID) {
		for (int counter = 0; counter < appointmentList.size(); counter++) {
			if (appointmentList.get(counter).getID().equals(appointmentID)) {
				appointmentList.get(counter).setDate(updatedDate);
				break;
			}
			if (counter == appointmentList.size() - 1) {
				System.out.println("Appointment with ID: " + appointmentID + " not found.");
			}
		}
	}

	public void updateAppointmentDesc(String updatedString, String appointmentID) {
		for (int counter = 0; counter < appointmentList.size(); counter++) {
			if (appointmentList.get(counter).getID().equals(appointmentID)) {
				appointmentList.get(counter).setDescription(updatedString);
				break;
			}
			if (counter == appointmentList.size() - 1) {
				System.out.println("Appointment with ID: " + appointmentID + " not found.");
			}
		}
	}
}