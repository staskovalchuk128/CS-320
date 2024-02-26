/*
 * Copyright 2024 Stanislav Kovalchuk
 */

public class Contact {
	private static final int CONTACT_PHONE_LEN = 10, CONTACT_ID_LEN = 10, CONTACT_FNAME_LEN = 10,
			CONTACT_LNAME_LEN = 10, CONTACT_ADDRESS_LEN = 30;
	private static final String INITIALIZER = "INITIAL", INITIALIZER_NUM = "1234567890";
	private String contactId, firstName ,lastName, phoneNumber, address;

	  Contact() {
	    this.contactId = INITIALIZER;
	    this.firstName = INITIALIZER;
	    this.lastName = INITIALIZER;
	    this.phoneNumber = INITIALIZER_NUM;
	    this.address = INITIALIZER;
	  }

	  Contact(String contactId) {
	    updateContactId(contactId);
	    this.firstName = INITIALIZER;
	    this.lastName = INITIALIZER;
	    this.phoneNumber = INITIALIZER_NUM;
	    this.address = INITIALIZER;
	  }

	  Contact(String contactId, String firstName) {
	    updateContactId(contactId);
	    updateFirstName(firstName);
	    this.lastName = INITIALIZER;
	    this.phoneNumber = INITIALIZER_NUM;
	    this.address = INITIALIZER;
	  }

	  Contact(String contactId, String firstName, String lastName) {
	    updateContactId(contactId);
	    updateFirstName(firstName);
	    updateLastName(lastName);
	    this.phoneNumber = INITIALIZER_NUM;
	    this.address = INITIALIZER;
	  }

	  Contact(String contactId, String firstName, String lastName,
	          String phoneNumber) {
	    updateContactId(contactId);
	    updateFirstName(firstName);
	    updateLastName(lastName);
	    updatePhoneNumber(phoneNumber);
	    this.address = INITIALIZER;
	  }

	  Contact(String contactId, String firstName, String lastName,
	          String phoneNumber, String address) {
	    updateContactId(contactId);
	    updateFirstName(firstName);
	    updateLastName(lastName);
	    updatePhoneNumber(phoneNumber);
	    updateAddress(address);
	  }

	  protected final String getContactId() { return contactId; }

	  protected final String getFirstName() { return firstName; }

	  protected final String getLastName() { return lastName; }

	  protected final String getPhoneNumber() { return phoneNumber; }

	  protected final String getAddress() { return address; }

	  protected void updateFirstName(String firstName) {
	    if (firstName == null) {
	      throw new IllegalArgumentException("First name can't be empty");
	    } else if (firstName.length() > CONTACT_FNAME_LEN) {
	      throw new IllegalArgumentException("First name can't be longer than " +
	                                         CONTACT_FNAME_LEN + " characters");
	    } else {
	      this.firstName = firstName;
	    }
	  }

	  protected void updateLastName(String lastName) {
	    if (lastName == null) {
	      throw new IllegalArgumentException("Last name can't be empty");
	    } else if (lastName.length() > CONTACT_LNAME_LEN) {
	      throw new IllegalArgumentException("Last name can't be longer than " +
	                                         CONTACT_LNAME_LEN + " characters");
	    } else {
	      this.lastName = lastName;
	    }
	  }

	  protected void updatePhoneNumber(String phoneNumber) {
	    String regex = "[0-9]+";
	    if (phoneNumber == null) {
	      throw new IllegalArgumentException("Phone number can't be empty.");
	    } else if (phoneNumber.length() != CONTACT_PHONE_LEN) {
	      throw new IllegalArgumentException(
	          "Phone number length invalid. Be sure it is " +
	          CONTACT_PHONE_LEN + " digits.");
	    } else if (!phoneNumber.matches(regex)) {
	      throw new IllegalArgumentException(
	          "Phone number can't have anything but numbers");
	    } else {
	      this.phoneNumber = phoneNumber;
	    }
	  }

	  protected void updateAddress(String address) {
	    if (address == null) {
	      throw new IllegalArgumentException("Address can't be empty");
	    } else if (address.length() > CONTACT_ADDRESS_LEN) {
	      throw new IllegalArgumentException("Address can't be longer than " +
	                                         CONTACT_ADDRESS_LEN +
	                                         " characters");
	    } else {
	      this.address = address;
	    }
	  }

	  protected void updateContactId(String contactId) {
	    if (contactId == null) {
	      throw new IllegalArgumentException("Contact ID can't be empty");
	    } else if (contactId.length() > CONTACT_ID_LEN) {
	      throw new IllegalArgumentException("Contact ID can't be longer than " +
	                                         CONTACT_ID_LEN + " characters");
	    } else {
	      this.contactId = contactId;
	    }
	  }
}
