package Contact;

import java.util.ArrayList;


public class ContactService {
	private ArrayList<Contact> contacts;
	
	public ContactService() {
		this.contacts = new ArrayList<>();
	}
	
	// For adding new contact
	public void addContact(Contact contact) {
		for (Contact c : contacts) {
			if (c.getContactID().equals(contact.getContactID())) {
				throw new IllegalArgumentException("Each contact ID has to be unique.");
			}
		
		}
		contacts.add(contact);
	}


// For deleting a contact by its ID

public void deleteContact(String contactID) {
	Contact contactToDelete = null;
	for (Contact c : contacts) {
		if (c.getContactID().equals(contactID)) {
			contactToDelete = c;
			break;
		}
	}
	
	if (contactToDelete != null) {
		contacts.remove(contactToDelete);
	}
	
	else {
		throw new IllegalArgumentException("The contact ID " + contactID + "doesn't exist in the records.");
	}
}
}

// For updating a contact by its ID

public void updateContact(String contactID, String firstName, String lastName, String number, String address) {
	Contact contact = null;
	for (Contact c : contacts) {
		if (c.getContactID().equals(contactID)) {
			contact = c;
			break;
		}
		
	}
	
	if (contact == null) {
		throw new IllegalArgumentException("The contact ID " +contactID + "doesn't exist in the records.");
	}
	
	if (firstName != null) contact.setFirstName(firstName);
	if (lastName != null) contact.setLastName(lastName);
	if (number != null) contact.setNumber(number);
	if (address != null) contact.setAddress(address);
}


// Retrieve contact by its ID

public Contact getContact(String contactID) {
	for (Contact c : contacts) {
		if (c.getContactID().equals(contactID)) {
			return c;
		}
	}
	return null;
}

}


	

