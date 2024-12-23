import java.util.Date;


public class Appointment {
	
	private final String appointmentId;
	private final Date appointmentDate;
	private final String description;

// Start with constructor

public Appointment(String appointmentId, Date appointmentDate, String description) {
	
	if (appointmentDate == null || appointmentDate.before(new Date())) {
		throw new IllegalArgumentException("Appointment date can't be null and has to be in the future.");
	}
	
	if (description == null || description.length() > 50) {
		throw new IllegalArgumentException("Description can't be null and has to be less than 50 characters.");
	}
	
	if (appointmentId == null || appointmentId.length() > 10) {
		throw new IllegalArgumentException("Appointment ID can't be null and has to be less than 10 characters.");
	}
	
	this.appointmentId = appointmentId;
	this.appointmentDate = appointmentDate;
	this.description = description;
}

// Getters for appointment

public Date getAppointmentDate() {
	return appointmentDate;
}

public String getAppointmentId() {
	return appointmentId;
}

public String getDescription() {
	return description;
}

}