// Jorge Torres
// SNHU CS 320
// Module Three Milestone

package module3;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ContactService {
	public String singularId; //variable for the UUID
	private List<Contact> contactList = new ArrayList<>();//creation of the list of contacts.
	
	{
		//assigning value to the singularId variable.
		singularId = UUID.randomUUID().toString().substring(
				0, Math.min(toString().length(), 10));
	}
	
	public void AddContact() {
		Contact contact = new Contact(newSingularId()); // initial sequence to add contact to list. 
		contactList.add(contact);
	}
	
	public void AddContact(String firstName) {
		Contact contact = new Contact(newSingularId(), firstName); //phase of sequence where it gets the firstName.
		contactList.add(contact);
	}
	
	public void AddContact(String firstName, String lastName) {
		Contact contact = new Contact(newSingularId(), firstName, lastName);//phase of sequence where it gets the lastName.
		contactList.add(contact);
	}
	
	public void AddContact(String firstName, String lastName, String digits) {
		Contact contact = new Contact(newSingularId(), firstName, lastName, digits);//phase of sequence where it gets the digits.
		contactList.add(contact);
	}
	
	public void AddContact(String firstName, String lastName, String digits, String address) {
		Contact contact = new Contact(newSingularId(), firstName, lastName, digits, address);//phase of sequence where it gets the address.
		contactList.add(contact);
	}
	
	public void updateFirstName(String id, String firstName) throws Exception{ //sequence to update the firstName.
		lookForContact(id).updateFirstName(firstName);
	}
	
	public void updateLastName(String id, String lastName) throws Exception{ //sequence to update the lastName.
		lookForContact(id).updateLastName(lastName);
	}
	
	public void updateDigits(String id, String digits) throws Exception{ //sequence to update the digits.
		lookForContact(id).updateDigits(digits);
	}
	
	public void updateAddress(String id, String address) throws Exception{ //sequence to update the address.
		lookForContact(id).updateAddress(address);
	}
	
	public void DelContact(String id) throws Exception{
		contactList.remove(lookForContact(id)); //sequence to delete a contact from the list.
	}
	
	
	protected List<Contact> getContactList() { return contactList;} //command to return the Contact List.
	
	
	
	private String newSingularId() { //assigns value to the variable newSingularId.
		return singularId = UUID.randomUUID().toString().substring(
				0, Math.min(toString().length(), 10));
	}
	
	private Contact lookForContact(String id) throws Exception{ //assigns value to the variable or Command lookForContact within the list. 
		int index = 0;
		while (index < contactList.size()) {
			if (id.equals(contactList.get(index).getContactId())) {
				return contactList.get(index);
			}
			index++;	
		}
		throw new Exception("This task is Impossible."); //if contact cannot be found it will throw this message.
	}
	 
}//end of class