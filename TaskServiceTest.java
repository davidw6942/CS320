import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Asserions.*;

public class TaskServiceTest {
	
	public void setUp() {
		taskService = new TaskService();
	}
	
	
	public void testValidAddTask() {
		Task task = new Task("1", "Task One", "First Task");
		taskService.addTask(task);
			
		Task retrievedTask = taskService.getTask("1");
		assertEquals("1", task.getTaskId());
		assertEquals("Task One", task.getName());
		assertEquals("First Task", task.getDescription());
		
	}
	
	public void testDeleteTask() {
		Task task = new Task("1", "Task One", "First Task");
		taskService.addTask(task);
        

		taskService.deleteTask("1");
		assertNull(taskService.getTask("1"));
	}
	
	public void testValidUpdateTaskNameAndDescription() {
		Task task = new Task("1", "Task One", "First Task");
		taskService.addTask(task);
		
		taskService.updateTask("1", "Updated Task", "Updated description");
		Task updatedTask = taskService.getTask("1");
		
		assertEquals("Updaated Task", updatedTask.getName()));
		assertEquals("Updated description", updatedTask.getDescription());
	}
	
	public void testAddTaskWithDuplicateId() {
		Task task1 = new Task("1", "Task One", "First Task");
		taskService.addTask(task1);
		
		Task task2 = new Task("1", "Task Two", "Second Task");
		IllegalArgumentException exception = assertThrow(IllegalArgumentException.class, () -> taskService.addTask(task2));
		assertEquals("Task ID is already in use", exception.getMessage());
	}
	
	public void testAddTaskNullTaskId() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			new Task(null, "Task One", "First Task");
		});
		
		assertEquals("Task Id can't be null or more than 10 characters", exception.getMessage());
		
	}
	
	public void testAddTaskNullName() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			new Task("1", null, "First Task");
		});
		
		assertEquals("Task name can't be null and can't be more than 20 characters", exception.getMessage());
		
	}
	
	public void testAddTaskNullDescription () {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			new Task("1", "Task One", null);
		});
		
		assertEquals("Task description can't be null or more than 50 characters", exception.getMessage());
		
	}
	
	public void testAddTaskExceedsMaxLengthTaskId() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			new Task("12345678910", "Task One", "First Task");
		});
		
		assertEquals("Task Id can't be null or more than 10 characters", exception.getMessage());
		
	}
	
	public void testAddTaskExceedsMaxLengthName() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			new Task("1", "This task name is too long to be accepted", "First Task");
		});
		
		assertEquals("Task name can't be null and can't be more than 20 characters", exception.getMessage());
		
	}
	
	public void testAddTaskExceedsMaxLengthDescription () {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			new Task("1", "Task One", "This description is way too long to be accepted byt the system");
		});
		
		assertEquals("Task description can't be null or more than 50 characters", exception.getMessage());
		
	}
	
	public void testDeleteTaskNonExistentTaskId() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			taskService.deleteTask("3");
		});
		assertEquals("No such task exists", exception.getMessage());
	}
	
	public void testUpdateTaskNonExistentTaskId() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			taskService.deleteTask("3");
		});
		assertEquals("No such task exists", exception.getMessage());
	}
	
	public void testUpdateTaskInvalidName() {
		Task task = new Task("1", "Task One", "First Task");
		taskService.addTask(task);
		
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			taskService.updateTask("1", "Name is too long to be valid for this update", null);
		});
		assertEqual("Name can't be more than 20 characters", exception.getMessage());
	}
	
	public void testUpdateTaskInvalidDescription() {
		Task task = new Task("1", "Task One", "First Task");
		taskService.addTask(task);
		
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			taskService.updateTask("1", null, "The description is way to long to be accepted in this system at this time");
		});
		assertEqual("Name can't be more than 50 characters", exception.getMessage());
	}

}
