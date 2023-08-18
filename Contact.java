// Jorge Torres
// SNHU CS 320
// Module Three Milestone

package module3;

public class Contact {
	
	//setup of length of variables and variables for the length conditions
	//setup of actual variables: firstName, lastName, digits(instead of PhoneNumber), and address.
	//setup of initial conditions 
	private static final int CONTACT_DIGITS_LENGTH = 10;
	private static final byte CONTACT_ID_LENGTH = 10;
	private static final byte CONTACT_FIRSTNAME_LENGTH = 10;
	private static final byte CONTACT_LASTNAME_LENGTH = 10;
	private static final byte CONTACT_ADDRESS_LENGTH = 30;
	private static final String INITIALIZER = "INITIAL";
	private static final String INITIALIZER_NUM = "1235559999";
	private String contactId;
	private String firstName;
	private String lastName;
	private String digits;
	private String address;
	
	Contact() { //constructor for the initial phase sequence
		this.contactId = INITIALIZER;
		this.firstName = INITIALIZER;
		this.lastName = INITIALIZER;
		this.digits = INITIALIZER_NUM;
		this.address = INITIALIZER;	
	}
	
	Contact(String contactId){ //first constructor for the update of the contactId only. 
		updateContactId(contactId);
		this.firstName = INITIALIZER;
		this.lastName = INITIALIZER;
		this.digits = INITIALIZER_NUM;
		this.address = INITIALIZER;
	}
	
	Contact(String contactId, String firstName) { //second constructor for the update of the contactId, and the firstName. 
		updateContactId(contactId);
		updateFirstName(firstName);
		this.lastName = INITIALIZER;
		this.digits = INITIALIZER_NUM;
		this.address = INITIALIZER;
	}
	
	Contact(String contactId, String firstName, String lastName) {//third constructor for the update of the contactId, firstName and the lastName.
		updateContactId(contactId);
		updateFirstName(firstName);
		updateLastName(lastName);
		this.digits = INITIALIZER_NUM;
		this.address = INITIALIZER;
	}
	
	Contact(String contactId, String firstName, String lastName, String digits) {//fourth constructor for the update of the contactId, firstName, lastName and the digits(PhoneNumber).
		updateContactId(contactId);
		updateFirstName(firstName);
		updateLastName(lastName);
		updateDigits(digits);
		this.address = INITIALIZER;
	}
	
	Contact(String contactId, String firstName, String lastName, String digits, String address) {// constructor All for the update of the contactId, firstName, lastName,the digits(PhoneNumber) and address.
		updateContactId(contactId);
		updateFirstName(firstName);
		updateLastName(lastName);
		updateDigits(digits);
		updateAddress(address);
	}
	//conditions command to return the variables.
	protected final String getContactId() { return contactId; }
	protected final String getFirstName() { return firstName; }
	protected final String getLastName() { return lastName; }
	protected final String getDigits() { return digits; }
	protected final String getAddress() { return address; }
	
	protected void updateFirstName(String firstName) { //this whole section bit is for the conditions(Exceptions) of input return and what the program will reply if the conditions are met when updating the firstName. 
		if (firstName == null) {
			throw new IllegalArgumentException("First Name cannot be empty");
		} else if (firstName.length() > CONTACT_FIRSTNAME_LENGTH) {
			throw new IllegalArgumentException("First name cannot be longer than" + CONTACT_FIRSTNAME_LENGTH + "characters");
		} else {
			this.firstName = firstName;
		}
	}
	
	protected void updateLastName(String lastName) { //this whole section bit is for the conditions(Exceptions) of input return and what the program will reply if the conditions are met when updating the lastName.
		if (lastName == null) {
			throw new IllegalArgumentException("Last Name cannot be empty");
		} else if (lastName.length() > CONTACT_LASTNAME_LENGTH) {
			throw new IllegalArgumentException("Last name cannot be longer than" + CONTACT_LASTNAME_LENGTH + "characters");
		} else {
			this.lastName = lastName;
		}
	}
	
	protected void updateDigits(String digits) { //this whole section bit is for the conditions(Exceptions) of input return and what the program will reply if the conditions are met when updating the digits.
		String regex = "[0-9]+";
		if (digits == null) {
			throw new IllegalArgumentException("Digits cannot be empty");
		} else if (digits.length() != CONTACT_DIGITS_LENGTH) {
			throw new IllegalArgumentException("Digits are invalid. Please ensure it is " + CONTACT_DIGITS_LENGTH + "numerical digits.");	
		} else if (!digits.matches(regex)) {
			throw new IllegalArgumentException("Digits cannot be anything have anything but numbers.");
		}else {
			this.digits = digits;
		}
	}
	
	protected void updateAddress(String address) { //this whole section bit is for the conditions(Exceptions) of input return and what the program will reply if the conditions are met when updating the address.
		if (address == null) {
			throw new IllegalArgumentException("Address cannot be empty");
		} else if (address.length() > CONTACT_ADDRESS_LENGTH) {
			throw new IllegalArgumentException("Address cannot be longer than" + CONTACT_ADDRESS_LENGTH + "characters");
		} else {
			this.address = address;
		}
	}
	
	protected void updateContactId(String contactId) { //this whole section bit is for the conditions(Exceptions) of input return and what the program will reply if the conditions are met when updating the contactId.
		if (contactId == null) {
			throw new IllegalArgumentException("Contact Id cannot be empty");
		} else if (contactId.length() > CONTACT_ID_LENGTH) {
			throw new IllegalArgumentException("Contact Id cannot be longer than" + CONTACT_ID_LENGTH + "characters");
		} else {
			this.contactId = contactId;
		}
	}	
}
