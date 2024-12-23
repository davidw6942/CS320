import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;


public class AppointmentServiceTest {
	
	private Date createDate(int year, int month, int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(year,  month - 1, day, 0, 0, 0);
		return calendar.getTime();
	}
	
	// Test adding appointment
	
	public void testAddAppointment() {
		AppointmentService service = new AppointmentService();
		Appointment appointment = new Appointment("I1224", createDate(2024, 12, 12), "Internet Installation");
		
		service.addAppointment();
		Appointment retrievedAppointment = service.getAppointment("I1224");
		
		assertNotNull(retrievedAppointment);
		assertEquals("I1224", retrievedAppointment.getAppointmentId());
		assertEquals("Internet installation", retrievedAppointment.getDescription());
		
	}
	
	// Test deleting appointment
	
	public void testDeleteAppointment() {
		Appointment Service service = new AppointmentService();
		Appointment appointment = new Appointment("I1224", createDate(2024, 12, 12), "Internet installation");
		
		service.addAppointment(appointment);
		service.deleteAppointment("I1224");
		
		assertNull(service.getAppointment("I1224"));
		
	}	
	}

}
