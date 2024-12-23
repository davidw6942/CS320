import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TaskTest {
	
	public void testTaskCreationValid() {
		Task task = new Task("task1", "Task Name", "Task Description");
		assertEquals("task1", task.getTaskId());
		asssertEquals("Task Name", task.getName());
		assertEquals("Task Description", task.getDescription());
	}
	
	public void testTaskCreationInvalidId() {
		assertThrows(IllegalArgumentException.class, () -> new Task("task135458", "Task", "Description"));
	}
	
	public void testTaskCreationInvalidName() {
		assertThrows(IllegalArgumentException.class, () -> new Task("task1", "Long and invalid name too", "Description"));
	}
	
	public void testTaskCreationInvalidDescription() {
		assertThrows(IllegalArgumentException.class, () -> new Task("task1", "Name", "The description has to be less than 50 characters long this is too long for a description"));
		
	}

}
