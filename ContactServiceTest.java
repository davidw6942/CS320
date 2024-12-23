import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



public class ContactServiceTest {
	
	private ContactService contactService;
	
	public void setUp() {
		contactService = new ContactService();
	}
	
	public void testAddContact() {
		Contact contact = new Contact("1", "Ben", "Ford", "8882516942", "208 Orange Ave");
		contactService.addContact(contact);;
		
		Contact retrievedContact = contactService.getContact("1");
		assertNotNull(retrievedContact);
		assertEquals("Ben", retrievedContact.getFirstName());
	}
	
	public void testAddDuplicateContactID() {
		Contact contact1 = new Contact("1", "Ben", "Ford", "8882516942", "208 Orange Ave");
		contactService.addContact(contact1);
		
		Contact contact2 = new Contact("1", "Lydia", "Borders", "8594453214", "632 Borders St.");
		assertThrows(IllegalArgumentException.class, () -> contactService.addContact(contact2));
	}
	
	public void testDeleteContact() {
		Contact contact = new Contact("1", "Ben", "Ford", "8882516942", "208 Orange Ave");
		contactService.addContact(contact);
		contactService.deleteContact("1");
		
		assertNull(contactService.getContact("1"));
	}
	
	public void testDeleteContactNonExistent() {
		assertThrows(IllegalArgumentException.class, () -> contactService.deleteContact("60"));
	}
	
	public void testUpdateContactFirstName() {
		Contact contact = new Contact("1", "Ben", "Ford", "8882516942", "208 Orange Ave");
		contactService.addContact(contact);
		
		contactService.updateContact("1", "Lydia", "null", "null", "null");
		Contact updatedContact = contactService.getContact("1");
		
		assertEquals("Lydia", updatedContact.getFirstName());
		assertEquals("Borders", updatedContact.getLastName());
		assertEquals("8594453214", updatedContact.getNumber());
		assertEquals("632 Borders St."());
	}
	
	public void testUpdateContactLastName() {
		Contact contact = new Contact("1", "Ben", "Ford", "8882516942", "208 Orange Ave");
		contactService.addContact(contact);
		
		contactService.updateContact("1", "null", "Borders", "null", "null");
		Contact updatedContact = contactService.getContact("1");
		
		assertEquals("Borders", updatedContact.getLastName());
		
	}
	
	public void testUpdateContactNumber() {
		Contact contact = new Contact("1", "Ben", "Ford", "8882516942", "208 Orange Ave");
		contactService.addContact(contact);
		
		contactService.updateContact("1", "null", "null", "8594453214", "null");
		Contact updatedContact = contactService.getContact("1");
		
		assertEquals("8594453214", updatedContact.getNumber());
		
	}
	
	public void testUpdateContactAddress() {
		Contact contact = new Contact("1", "Ben", "Ford", "8882516942", "208 Orange Ave");
		contactService.addContact(contact);
		
		contactService.updateContact("1", "null", "null", "null", "16 Kentucky Ave");
		Contact updatedContact = contactService.getContact("1");
		
		assertEquals("16 Kentucky Ave", updatedContact.getNumber());
		
	}
	
	public void testContactInvalidFirstName() {
		Contact contact = new Contact("1", "Ben", "Ford", "8882516942", "208 Orange Ave");
		contactService.addContact(contact);
		
		assertThrows(IllegalArgumentException.class, () -> contactService.updatedContact("1", "Toolongfirstname", "null", "null", "null" )
	}
	
	public void testContactInvalidLastName() {
		Contact contact = new Contact("1", "Ben", "Ford", "8882516942", "208 Orange Ave");
		contactService.addContact(contact);
		
		assertThrows(IllegalArgumentException.class, () -> contactService.updatedContact("1", "null", "Toolonglastname", "null", "null" )
	}
	
	public void testContactInvalidNumber() {
		Contact contact = new Contact("1", "Ben", "Ford", "8882516942", "208 Orange Ave");
		contactService.addContact(contact);
		
		assertThrows(IllegalArgumentException.class, () -> contactService.updatedContact("1", "null", "null", "85945678952145", "null" )
	}
	
	public void testContactInvalidAddress() {
		Contact contact = new Contact("1", "Ben", "Ford", "8882516942", "208 Orange Ave");
		contactService.addContact(contact);
		
		assertThrows(IllegalArgumentException.class, () -> contactService.updatedContact("1", "null", "null", "null", "The address provided is entirely too long to be accepted." )
	}
	
	public void testUpdatedNonExistentContact() {
		assertThrows(IllegalArgumentException.class, () -> contactService.updatedContact("2", "Mike", "Jones", "3265488896", "111 Rap Rd."));
	}
	

}
