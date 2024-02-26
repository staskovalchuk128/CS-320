/*
 * Copyright 2024 Stanislav Kovalchuk
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
  protected String contactId, firstNameTest, lastNameTest, phoneNumberTest,
      addressTest;
  protected String longContactId, longFirstName, longLastName,
      longPhoneNumber, shortPhoneNumber, longAddress;

  @BeforeEach
  void setUp() {
	  contactId = "123456789";
	  firstNameTest = "Stas";
	  lastNameTest = "Kolchin";
	  phoneNumberTest = "8913456456";
	  addressTest = "1111 N hway 123 bypass";
	  longContactId = "5432534523452452345245";
	  longFirstName = "Stanislav Viktorovich ";
	  longLastName = "Kolivenchikovlaskowski";
	  longPhoneNumber = "89135532255677943";
	  shortPhoneNumber = "83130";
	  longAddress = "1111 N hway 123 bypass, Dallas, Texas, 754332-54";
  }

  @Test
  void newContactTest() {
    ContactService service = new ContactService();
    service.newContact();
    assertAll(
        "service",
        ()-> assertNotNull(service.getContactList().get(0).getContactId()),
        ()-> assertEquals("INITIAL", service.getContactList().get(0).getFirstName()),
        ()-> assertEquals("INITIAL", service.getContactList().get(0).getLastName()),
        ()-> assertEquals("1234567890", service.getContactList().get(0).getPhoneNumber()),
        ()-> assertEquals("INITIAL", service.getContactList().get(0).getAddress()));
    service.newContact(firstNameTest);
    assertAll(
        "service",
        ()-> assertNotNull(service.getContactList().get(1).getContactId()),
        ()-> assertEquals(firstNameTest, service.getContactList().get(1).getFirstName()),
        ()-> assertEquals("INITIAL", service.getContactList().get(1).getLastName()),
        ()-> assertEquals("1234567890", service.getContactList().get(1).getPhoneNumber()),
        ()-> assertEquals("INITIAL", service.getContactList().get(1).getAddress()));
    service.newContact(firstNameTest, lastNameTest);
    assertAll(
        "service",
        ()-> assertNotNull(service.getContactList().get(2).getContactId()),
        ()-> assertEquals(firstNameTest, service.getContactList().get(2).getFirstName()),
        ()-> assertEquals(lastNameTest, service.getContactList().get(2).getLastName()),
        ()-> assertEquals("1234567890", service.getContactList().get(2).getPhoneNumber()),
        ()-> assertEquals("INITIAL", service.getContactList().get(2).getAddress()));
    service.newContact(firstNameTest, lastNameTest, phoneNumberTest);
    assertAll(
        "service",
        ()-> assertNotNull(service.getContactList().get(3).getContactId()),
        ()-> assertEquals(firstNameTest, service.getContactList().get(3).getFirstName()),
        ()-> assertEquals(lastNameTest, service.getContactList().get(3).getLastName()),
        ()-> assertEquals(phoneNumberTest,service.getContactList().get(3).getPhoneNumber()),
        ()-> assertEquals("INITIAL", service.getContactList().get(3).getAddress()));
    service.newContact(firstNameTest, lastNameTest, phoneNumberTest,
                       addressTest);
    assertAll(
        "service",
        ()-> assertNotNull(service.getContactList().get(4).getContactId()),
        ()-> assertEquals(firstNameTest, service.getContactList().get(4).getFirstName()),
        ()-> assertEquals(lastNameTest, service.getContactList().get(4).getLastName()),
        ()-> assertEquals(phoneNumberTest, service.getContactList().get(4).getPhoneNumber()),
        ()-> assertEquals(addressTest, service.getContactList().get(4).getAddress()));
  }

  @Test
  void deleteContactTest() {
    ContactService service = new ContactService();
    service.newContact();
    assertThrows(Exception.class, () -> service.deleteContact(contactId));
    assertAll(()-> service.deleteContact(service.getContactList().get(0).getContactId()));
  }

  @Test
  void updateFirstNameTest() throws Exception {
    ContactService service = new ContactService();
    service.newContact();
    service.updateFirstName(service.getContactList().get(0).getContactId(),
                            firstNameTest);
    assertEquals(firstNameTest, service.getContactList().get(0).getFirstName());
    assertThrows(IllegalArgumentException.class,
                 ()-> service.updateFirstName(service.getContactList().get(0).getContactId(), longFirstName));
    assertThrows(IllegalArgumentException.class,
                 ()-> service.updateFirstName(service.getContactList().get(0).getContactId(), null)); 
    assertThrows(Exception.class,() -> service.updateFirstName(contactId, firstNameTest));
  }

  @Test
  void updateLastNameTest() throws Exception {
    ContactService service = new ContactService();
    service.newContact();
    service.updateLastName(service.getContactList().get(0).getContactId(),
                           lastNameTest);
    assertEquals(lastNameTest, service.getContactList().get(0).getLastName());
    assertThrows(IllegalArgumentException.class,
                 ()-> service.updateLastName(service.getContactList().get(0).getContactId(),longLastName));
    assertThrows(IllegalArgumentException.class,
                 ()-> service.updateLastName(service.getContactList().get(0).getContactId(), null));
    assertThrows(Exception.class,() -> service.updateLastName(contactId, lastNameTest));
  }

  @Test
  void updatePhoneNumberTest() throws Exception {
    ContactService service = new ContactService();
    service.newContact();
    service.updatePhoneNumber(service.getContactList().get(0).getContactId(),
                              phoneNumberTest);
    assertEquals(phoneNumberTest,
                 service.getContactList().get(0).getPhoneNumber());
    assertThrows(IllegalArgumentException.class,
                 ()-> service.updatePhoneNumber(service.getContactList().get(0).getContactId(),longPhoneNumber));
    assertThrows(IllegalArgumentException.class,
                 ()-> service.updatePhoneNumber(service.getContactList().get(0).getContactId(),shortPhoneNumber));
    assertThrows(
        IllegalArgumentException.class,
        ()-> service.updatePhoneNumber(service.getContactList().get(0).getContactId(), contactId));
    assertThrows(IllegalArgumentException.class,
                 ()-> service.updatePhoneNumber(service.getContactList().get(0).getContactId(), null));
    assertThrows(Exception.class,
                 ()-> service.updatePhoneNumber(contactId, lastNameTest));
  }

  @Test
  void updateAddressTest() throws Exception {
    ContactService service = new ContactService();
    service.newContact();
    service.updateAddress(service.getContactList().get(0).getContactId(),
                          addressTest);
    assertEquals(addressTest, service.getContactList().get(0).getAddress());
    assertThrows(IllegalArgumentException.class,
                 ()-> service.updateAddress(service.getContactList().get(0).getContactId(),longAddress));
    assertThrows(IllegalArgumentException.class,
                 ()-> service.updateAddress(service.getContactList().get(0).getContactId(), null));
    assertThrows(Exception.class,
                 ()-> service.updateAddress(contactId, addressTest));
  }
}
