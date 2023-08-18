// Jorge Torres
// SNHU CS 320
// Module Three Milestone

package module3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactTest {
	
	//creation of variables for the test
	protected String contactId, firstNameTest, lastNameTest, digitsTest,addressTest;
	protected String longerContactId, longerFirstName, longerLastName,longerDigits, shorterDigits, longerAddress;
	

	@BeforeEach
	void setUp() throws Exception {// setup before test, assigning value to the variables.
		contactId = "4124ASE425";
		firstNameTest = "Pepe";
		lastNameTest = "Charleston";
		digitsTest = "4014458778";
		addressTest = "1 One St Hope RI 04954";
		longerContactId = "112233445566778899";
		longerFirstName = "Juan Manuel Smithy";
		longerLastName = "Heisenberg the Third";
		longerDigits = "50244744744";
		shorterDigits = "1234567";
		longerAddress = "E-16 Laurel St, Colinas de Guaynabo, Guaynabo PR, 00969-6209";
	}

	@Test //test to verify sequence phases work in Initial sequence.
	final void testContact() {
		Contact contact = new Contact();
		assertAll("Contructor",
				() 
					-> assertNotNull(contact.getContactId()),
				()
					-> assertNotNull(contact.getFirstName()),
				()
					-> assertNotNull(contact.getLastName()),
				() 
					-> assertNotNull(contact.getDigits()),
				()
					-> assertNotNull(contact.getAddress()));
	}

	@Test
	final void testContactIdContstructorTest() { //constructor one, testing the contactId sequence.
		Contact contact = new Contact(contactId);
		assertAll("Contructor One",
				() 
					-> assertEquals( contactId, contact.getContactId()),
				()
					-> assertNotNull(contact.getFirstName()),
				()
					-> assertNotNull(contact.getLastName()),
				() 
					-> assertNotNull(contact.getDigits()),
				()
					-> assertNotNull(contact.getAddress()));
	}

	@Test
	final void testContactIdAndFirstNameConstructorTest() { //constructor two, testing the secondary sequence adding firstName.
		Contact contact = new Contact(contactId, firstNameTest);
		assertAll("Contructor Two",
				() 
					-> assertEquals( contactId, contact.getContactId()),
				()
					-> assertEquals(firstNameTest,contact.getFirstName()),
				()
					-> assertNotNull(contact.getLastName()),
				() 
					-> assertNotNull(contact.getDigits()),
				()
					-> assertNotNull(contact.getAddress()));
	}

	@Test
	final void testContactIdAndFirstNameAndLastNameConstructorTest() { // constructor three, testing the 3rd sequence adding now lastName.
		Contact contact = new Contact(contactId, firstNameTest, lastNameTest);
		assertAll("Contructor Three",
				() 
					-> assertEquals( contactId, contact.getContactId()),
				()
					-> assertEquals(firstNameTest,contact.getFirstName()),
				()
					-> assertEquals(lastNameTest, contact.getLastName()),
				() 
					-> assertNotNull(contact.getDigits()),
				()
					-> assertNotNull(contact.getAddress()));
	}

	@Test
	final void testContactIdAndFirstNameAndLastNameAndDigitsConstructorTest() { // 4th constructor, testing the 4th sequence adding now the digits. 
		Contact contact = new Contact(contactId, firstNameTest, lastNameTest, digitsTest);
		assertAll("Contructor Four",
				() 
					-> assertEquals( contactId, contact.getContactId()),
				()
					-> assertEquals(firstNameTest,contact.getFirstName()),
				()
					-> assertEquals(lastNameTest, contact.getLastName()),
				() 
					-> assertEquals(digitsTest,contact.getDigits()),
				()
					-> assertNotNull(contact.getAddress()));
	}

	@Test
	final void testContactAllConstructorTest() { //mother of ALL constructor, testing all including now the address.
		Contact contact = new Contact(contactId, firstNameTest, lastNameTest, digitsTest, addressTest);
		assertAll("Contructor All",
				() 
					-> assertEquals( contactId, contact.getContactId()),
				()
					-> assertEquals(firstNameTest,contact.getFirstName()),
				()
					-> assertEquals(lastNameTest, contact.getLastName()),
				() 
					-> assertEquals(digitsTest,contact.getDigits()),
				()
					-> assertEquals(addressTest, contact.getAddress()));
	}

	

	@Test
	final void testUpdateFirstName() { //individual test of the updateFirstName sequence and its exceptions. 
		Contact contact = new Contact();
		contact.updateFirstName(firstNameTest);
		assertAll(
				"first name",
				()
					-> assertEquals(firstNameTest, contact.getFirstName()),
				()
					-> assertThrows(IllegalArgumentException.class,
											() -> contact.updateFirstName(null)),
				()
					-> assertThrows(IllegalArgumentException.class,
											() -> contact.updateFirstName(longerFirstName)));
	}

	@Test
	final void testUpdateLastName() { //individual test of the updateLastName sequence and its exceptions. 
		Contact contact = new Contact();
		contact.updateLastName(lastNameTest);
		assertAll(
				"last name ",
				()
					-> assertEquals(lastNameTest, contact.getLastName()),
				()
					-> assertThrows(IllegalArgumentException.class,
											() -> contact.updateLastName(null)),
				()
					-> assertThrows(IllegalArgumentException.class,
											() -> contact.updateLastName(longerLastName)));
	}

	@Test
	final void testUpdateDigits() { //individual test of the updateDigits sequence and its exceptions. 
		Contact contact = new Contact();
		contact.updateDigits(digitsTest);
		assertAll(
				"Digits",
				()
					-> assertEquals(digitsTest, contact.getDigits()),
				()
					-> assertThrows(IllegalArgumentException.class,
											() -> contact.updateDigits(null)),
				()
					-> assertThrows(IllegalArgumentException.class,
											() -> contact.updateDigits(longerDigits)),
				()
					-> assertThrows(IllegalArgumentException.class,
											() -> contact.updateDigits(shorterDigits)),
				()
					-> assertThrows(IllegalArgumentException.class,
											() -> contact.updateDigits(contactId)));
	}

	@Test
	final void testUpdateAddress() { //individual test of the updateAddress sequence and its exceptions. 
		Contact contact = new Contact();
		contact.updateAddress(addressTest);
		assertAll(
				"Address",
				()
					-> assertEquals(addressTest, contact.getAddress()),
				()
					-> assertThrows(IllegalArgumentException.class,
											() -> contact.updateAddress(null)),
				()
					-> assertThrows(IllegalArgumentException.class,
											() -> contact.updateAddress(longerAddress)));
	}

	@Test
	final void testUpdateContactId() { //individual test of the updateContactId sequence and its exceptions. 
		Contact contact = new Contact();
		contact.updateContactId(contactId);
		assertAll(
				"contact ID",
				()
					-> assertEquals(contactId, contact.getContactId()),
				()
					-> assertThrows(IllegalArgumentException.class,
											() -> contact.updateContactId(null)),
				()
					-> assertThrows(IllegalArgumentException.class,
											() -> contact.updateContactId(longerContactId)));
	}
}
