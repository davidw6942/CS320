import java.util.ArrayList;
import java.util.List;


public class AppointmentService {
	
	private final List<Appointment> appointments = new ArrayList<>();
	
	// To delete an appointment	
	public void deleteAppointment(String appointmentId) {
		Appointment appointmentToDelete = null;
		for (Appointment appointment : appointments) {
			if (appointment.getAppointmentId().equals(appointmentId)) {
				appointmentToDelete = appointment;
				break;
			}
		}
		
		if (appointmentToDelete == null) {
			throw new IllegalArgumentException("This appointment doesn't exist.");
		}
		
		appointments.remove(appointmentToDelete);
	}
	
	// To look up an appointment by the Id
	public Appointment getAppointment(String appointmentId) {
		for (Appointment appointment : appointments) {
			if (appointment.getAppointmentId().equals(appointmentId)) {
				return appointment;
			}
		}
		// If appointment Id isn't found return as null
		return null;
		
	}
	
	// To add an appointment
	
	public void addAppointment(Appointment appointment) {
		for (Appointment existingAppointment : appointments) {
			if (existingAppointment.getAppointmentId().equals(appointment.getAppointmentId())) {
				throw new IllegalArgumentException("Appointment ID needs to be unique to add.");
			}
		}
		
		appointments.add(appointment);
	}	

}
