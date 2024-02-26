/*
 * Copyright 2024 Stanislav Kovalchuk
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ContactTest {

	protected String contactId, firstNameTest, lastNameTest, phoneNumberTest,
    addressTest;
	
	protected String tenCharContactId, tenCharFirstNameTest, tenCharLastNameTest,
	thirtyCharAddressTest;
	
	protected String longContactId, longFirstName, longLastName,
    longPhoneNumber, shortPhoneNumber, longAddress;

	@BeforeEach
	void setUp() {
	  contactId = "1";
	  firstNameTest = "Stas";
	  lastNameTest = "Kolchin";
	  phoneNumberTest = "8913456456";
	  addressTest = "1111 N hway";
	  
	  tenCharContactId = "1234567890";
	  tenCharFirstNameTest = "Lorem ipsu";
	  tenCharLastNameTest = "Lorem ipsu";
	  thirtyCharAddressTest = "Lorem ipsum dolor sit amet lor";
	  
	  longContactId = "5432534523452452345245";
	  longFirstName = "Stanislav Viktorovich ";
	  longLastName = "Kolivenchikovlaskowski";
	  longPhoneNumber = "89135532255677943";
	  shortPhoneNumber = "83130";
	  longAddress = "1111 N hway 123 bypass, Dallas, Texas, 754332-54";
	}
	
	
	@Test
	@DisplayName("Test Contact ID")
	void TestContactId() {
		Contact contact = new Contact(contactId);
		
		//less than 10 char test
		assertAll("Contact ID",
				()-> assertEquals(contactId, contact.getContactId()));
				
		//10 char test, null and more than 10 char test
		contact.updateContactId(tenCharContactId);
		assertAll("Contact ID",
				()-> assertEquals(tenCharContactId, contact.getContactId()),
		        ()-> assertThrows(IllegalArgumentException.class, () -> contact.updateContactId(null)),
		        ()-> assertThrows(IllegalArgumentException.class, () -> contact.updateContactId(longContactId)));		

		
	}
	
	
	@Test
	@DisplayName("Test Contact First Name")
	void TestContactFirstName() {
		Contact contact = new Contact(contactId, firstNameTest);
		
		//less than 10 char test
		assertAll("Contact First Name",
				()-> assertEquals(firstNameTest, contact.getFirstName()));
				
		//10 char test, null and more than 10 char test
		contact.updateFirstName(tenCharFirstNameTest);
		assertAll("Contact First Name",
				()-> assertEquals(tenCharFirstNameTest, contact.getFirstName()),
		        ()-> assertThrows(IllegalArgumentException.class, () -> contact.updateFirstName(null)),
		        ()-> assertThrows(IllegalArgumentException.class, () -> contact.updateFirstName(longFirstName)));		
	}
	
	
	@Test
	@DisplayName("Test Contact Last Name")
	void TestContactLastName() {
		Contact contact = new Contact(contactId, firstNameTest, lastNameTest);
		
		//less than 10 char test
		assertAll("Contact Last Name",
				()-> assertEquals(lastNameTest, contact.getLastName()));
				
		//10 char test, null and more than 10 char test
		contact.updateLastName(tenCharLastNameTest);
		assertAll("Contact Last Name",
				()-> assertEquals(tenCharLastNameTest, contact.getLastName()),
		        ()-> assertThrows(IllegalArgumentException.class, () -> contact.updateLastName(null)),
		        ()-> assertThrows(IllegalArgumentException.class, () -> contact.updateLastName(longLastName)));		
	}
	
	
	@Test
	@DisplayName("Test Contact phone")
	void TestContactPhone() {
		Contact contact = new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest);
		
		//10 char test
		assertAll("Contact phone",
				()-> assertEquals(phoneNumberTest, contact.getPhoneNumber()));
				
		//less or more than 10 char and null test
		assertAll("Contact Address",
		        ()-> assertThrows(IllegalArgumentException.class, () -> contact.updatePhoneNumber(null)),
		        ()-> assertThrows(IllegalArgumentException.class, () -> contact.updatePhoneNumber(longPhoneNumber)),
		        ()-> assertThrows(IllegalArgumentException.class, () -> contact.updatePhoneNumber(shortPhoneNumber)));		
	}
	
	
	@Test
	@DisplayName("Test Contact address")
	void TestContactAddress() {
		Contact contact = new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest, addressTest);
		
		//less than 30 char test
		assertAll("Contact address",
				()-> assertEquals(addressTest, contact.getAddress()));
		
		//30 char test, null and more than 30 char test
		contact.updateAddress(thirtyCharAddressTest);
		assertAll("Contact address",
				()-> assertEquals(thirtyCharAddressTest, contact.getAddress()),
		        ()-> assertThrows(IllegalArgumentException.class, () -> contact.updateAddress(null)),
		        ()-> assertThrows(IllegalArgumentException.class, () -> contact.updateAddress(longAddress)));
	}
}
