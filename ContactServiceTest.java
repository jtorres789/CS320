// Jorge Torres
// SNHU CS 320
// Module Three Milestone

package module3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactServiceTest {

	//creation of variables
	protected String contactId, firstNameTest, lastNameTest, digitsTest,addressTest;
	protected String longerContactId, longerFirstName, longerLastName,longerDigits, shorterDigits, longerAddress;
	

	@BeforeEach 
	void setUp() throws Exception { // setup before test, assigning value to the variables.
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

	@Test
	final void testAddContact() { //entire block that will test the sequence of finding the variables firstName, lastName, digits, and address. it starts with contactId.
		ContactService service = new ContactService();
		service.AddContact();
		assertAll("Service",
				() 
					-> assertNotNull(service.getContactList().get(0).getContactId()),
				()
					-> assertEquals("INITIAL", service.getContactList().get(0).getFirstName()),
				() 
					-> assertEquals("INITIAL", service.getContactList().get(0).getLastName()),
				()
					-> assertEquals("1235559999", service.getContactList().get(0).getDigits()),
				()
					-> assertEquals("INITIAL", service.getContactList().get(0).getAddress()));
		
		service.AddContact(firstNameTest);
		assertAll("Service",
				() 
				-> assertNotNull(service.getContactList().get(1).getContactId()),
			()
				-> assertEquals(firstNameTest, service.getContactList().get(1).getFirstName()),
			() 
				-> assertEquals("INITIAL", service.getContactList().get(1).getLastName()),
			()
				-> assertEquals("1235559999", service.getContactList().get(1).getDigits()),
			()
				-> assertEquals("INITIAL", service.getContactList().get(1).getAddress()));
		
		service.AddContact(firstNameTest, lastNameTest);
		assertAll("Service",
				() 
				-> assertNotNull(service.getContactList().get(2).getContactId()),
			()
				-> assertEquals(firstNameTest, service.getContactList().get(2).getFirstName()),
			()
				-> assertEquals(lastNameTest, service.getContactList().get(2).getLastName()),
			()
				-> assertEquals("1235559999", service.getContactList().get(2).getDigits()),
			()
				-> assertEquals("INITIAL", service.getContactList().get(2).getAddress()));
		
		service.AddContact(firstNameTest, lastNameTest, digitsTest);
		assertAll("Service",
				() 
				-> assertNotNull(service.getContactList().get(3).getContactId()),
			()
				-> assertEquals(firstNameTest, service.getContactList().get(3).getFirstName()),
			()
				-> assertEquals(lastNameTest, service.getContactList().get(3).getLastName()),
			()
				-> assertEquals(digitsTest, service.getContactList().get(3).getDigits()),
			()
				-> assertEquals("INITIAL", service.getContactList().get(3).getAddress()));
		
		service.AddContact(firstNameTest, lastNameTest, digitsTest, addressTest);
		assertAll("Service",
				() 
				-> assertNotNull(service.getContactList().get(4).getContactId()),
			()
				-> assertEquals(firstNameTest, service.getContactList().get(4).getFirstName()),
			()
				-> assertEquals(lastNameTest, service.getContactList().get(4).getLastName()),
			()
				-> assertEquals(digitsTest, service.getContactList().get(4).getDigits()),
			()
				-> assertEquals(addressTest, service.getContactList().get(4).getAddress()));
	}

	@Test
	final void testUpdateFirstName() throws Exception { //test individually the service update for the firstName and all its exceptions are service tested.
		ContactService service = new ContactService();
		service.AddContact();
		service.updateFirstName(service.getContactList().get(0).getContactId(), firstNameTest);
		
		assertEquals(firstNameTest, service.getContactList().get(0).getFirstName());
		
		assertThrows(IllegalArgumentException.class,
				()
					-> service.updateFirstName(service.getContactList().get(0).getContactId(), longerFirstName));
		
		assertThrows(IllegalArgumentException.class,
				()
					-> service.updateFirstName(service.getContactList().get(0).getContactId(), null));
		
		assertThrows(Exception.class,
				()
					-> service.updateFirstName(contactId, firstNameTest));
	}

	@Test
	final void testUpdateLastName() throws Exception { //test individually the service update for the lastName and all its exceptions are service tested.
		ContactService service = new ContactService();
		service.AddContact();
		service.updateLastName(service.getContactList().get(0).getContactId(), lastNameTest);
		
		assertEquals(lastNameTest, service.getContactList().get(0).getLastName());
		
		assertThrows(IllegalArgumentException.class,
				()
					-> service.updateLastName(service.getContactList().get(0).getContactId(), longerLastName));
		
		assertThrows(IllegalArgumentException.class,
				()
					-> service.updateLastName(service.getContactList().get(0).getContactId(), null));
		
		assertThrows(Exception.class,
				()
					-> service.updateLastName(contactId, lastNameTest));
	}

	@Test
	final void testUpdateDigits() throws Exception { //test individually the service update for the digits and all its exceptions are service tested.
		ContactService service = new ContactService();
		service.AddContact();
		service.updateDigits(service.getContactList().get(0).getContactId(), digitsTest);
		
		assertEquals(digitsTest, service.getContactList().get(0).getDigits());
		
		assertThrows(IllegalArgumentException.class,
				()
					-> service.updateDigits(service.getContactList().get(0).getContactId(), longerDigits));
		
		assertThrows(IllegalArgumentException.class,
				()
					-> service.updateDigits(service.getContactList().get(0).getContactId(), shorterDigits));
		
		assertThrows(IllegalArgumentException.class,
				()
					-> service.updateDigits(service.getContactList().get(0).getContactId(), null));
		
		assertThrows(Exception.class,
				()
					-> service.updateDigits(contactId, digitsTest));
	}

	@Test
	final void testUpdateAddress() throws Exception { //test individually the service update for the address and all its exceptions are service tested.
		ContactService service = new ContactService();
		service.AddContact();
		service.updateAddress(service.getContactList().get(0).getContactId(), addressTest);
		
		assertEquals(addressTest, service.getContactList().get(0).getAddress());
		
		assertThrows(IllegalArgumentException.class,
				()
					-> service.updateAddress(service.getContactList().get(0).getContactId(), longerAddress));
		
		assertThrows(IllegalArgumentException.class,
				()
					-> service.updateAddress(service.getContactList().get(0).getContactId(), null));
		
		assertThrows(Exception.class,
				()
					-> service.updateAddress(contactId, addressTest));
	}

	@Test
	final void testDelContact() { //test individually the service update for the DelContact and all its exceptions are service tested.
		ContactService service = new ContactService();
		service.AddContact();
		assertThrows(Exception .class, () -> service.DelContact(contactId));
		assertAll(()
				-> service.DelContact(
						service.getContactList().get(0).getContactId()));
	}

}
