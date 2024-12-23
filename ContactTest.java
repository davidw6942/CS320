import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ContactTest {
	
	public void testValidContactCreation() {
		Contact contact = new Contact("1", "Ben", "Ford", "8882516942", "208 Orange Ave");
		
		assertEquals("1", contact.getContactID());
		assertEquals("Ben", contact.getFirstName());
		assertEquals("Ford", contact.getLastName());
		assertEquals("8882516942", contact.getNumber());
		assertEquals("208 Orange Ave", contact.getAddress());
	}
	
	public void testInvalidContactID() {
		assertThrows(IllegalArgumentException.class, () -> new Contact(null, "Ben", "Ford", "8882516942", "208 Orange Ave"));
		assertThrows(IllegalArgumentException.class, () -> new Contact("15890", "Ben", "Ford", "8882516942", "208 Orange Ave"));
	}
	
	public void testInvalidFirstName() {
		assertThrows(IllegalArgumentException.class, () -> new Contact("1", null, "Ford", "8882516942", "208 Orange Ave"));
		assertThrows(IllegalArgumentException.class, () -> new Contact("1", "Benfordistoolongofaname", "Ford", "8882516942", "208 Orange Ave"));
		
	}
	
	public void testInvalidLastName() {
		assertThrows(IllegalArgumentException.class, () -> new Contact("1", "Ben", null, "8882516942", "208 Orange Ave"));
		assertThrows(IllegalArgumentException.class, () -> new Contact("1", "Ben", "Fordlongnametoolong", "8882516942", "208 Orange Ave"));
		
	}
	
	public void testInvalidNumber() {
		assertThrows(IllegalArgumentException.class, () -> new Contact("1", "Ben", "Ford", null, "208 Orange Ave"));
		assertThrows(IllegalArgumentException.class, () -> new Contact("1", "Ben", "Ford", "888cb5f942", "208 Orange Ave"));
		assertThrows(IllegalArgumentException.class, () -> new Contact("1", "Ben", "Ford", "888251", "208 Orange Ave"));
		
	}
	
	public void testInvalidAddress() {
		assertThrows(IllegalArgumentException.class, () -> new Contact("1", "Ben", "Ford", "8882516942", null));
		assertThrows(IllegalArgumentException.class, () -> new Contact("1", "Ben", "Ford", "8882516942", "addressisinvalidortoolongfortherequirements"));
		
	}
	
	public void testGettersAndSetters() {
		Contact contact = new Contact("1", "Ben", "Ford", "8882516942", "208 Orange Ave");
		
		contact.setFirstName("Lydia");
		contact.setLastName("Borders");
		contact.setNumber("8594453214");
		contact.setAddress("632 Borders St.");
		
		assertEquals("Lydia", contact.getFirstName());
		assertEquals("Borders", contact.getLastName());
		assertEquals("8594453214", contact.getNumber());
		assertEquals("632 Borders St.", contact.getAddress());
		
	}
	
	}
