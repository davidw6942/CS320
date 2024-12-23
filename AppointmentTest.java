import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.Calendar;
import static org.junit.jupiter.api.Assertions.*;


public class AppointmentTest {
	
	private Date createDate(int year, int month, int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(year,  month - 1, day, 0, 0, 0);
		return calendar.getTime();
	}
	
	// Tests for validity 
	
	public void testValidAppointment() {
		Date appointmentDate = createDate(2024, 12, 12);
		Appointment appointment = new Appointment("I1224", appointmentDate, "Internet installation");
		
		
		assertEquals("I1224", appointment.getAppointmentId());
		assertEquals(appointmentDate, appointment.getAppointmentDate());
		assertEquals("Internet installation", appointment.getDescription());
	}
	
	public void testInvalidAppointmentDateInPast() {
		Date pastDate = createDate(2021, 11, 12);
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("I1224", pastDate, "Appointment date can't be in the past");
		});
		
	}
	
	public void testInvalidDescriptionTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("I1224", createDate(2024, 12, 12), "The description is far too long for it to be allowed by the parameters set forth for the project.");
		});
	}
	
	public void testNullAppointmentDate() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("I1224", null, "Date can't be null");
		});
	}
	
	public void testNullDescription() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("I1224", createDate(2024, 12, 12), null);
		});
	}
	
	public void testNullAppointmentId() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(null, createDate(2024, 12, 12), "ID can't be null");
		});
	}
	
	public void testInvalidAppointmentIdTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("ID1333944938493", createDate(2024, 12, 12), "ID is too long");
		});
	}
	
	
	

}
