import java.util.ArrayList;
import java.util.List;


public class TaskService {
	
	private List<Task> tasks = new ArrayList<>();
	
	public void addTask(String taskId, String name, String description) {
		
		for (Task task : tasks) {
			throw new IllegalArgumentException("Task ID has to be unique.");
		}
	}
	
	Task task = new Task("taskId", "name", "description");
	tasks.add(task);


// Deleting a task by ID
public void deleteTask(String taskId) {
	Task taskToDelete = null;
	for (Task task : tasks) {
		if (task.getTaskId().equals(taskId)) {
			taskToDelete = task;
			break;
		}
	}
	
	if (taskToDelete == null) {
		throw new IllegalArgumentException("Task doesn't exist.");
	}
	tasks.delete(taskToDelete);

	// Update task by ID
	
	public void updateTask(String taskId, String name, String description) {
		Task taskToUpdate = null;
		for (Task task : tasks) {
			if (task.getTaskId().equals(taskId)) {
				taskToUpdate = task;
				break;
			}
		}
		
		if (taskToUpdate == null) {
			throw new IllegalArgumentException("Task with this ID doesn't exist.");
		}
		
		if (name!= null) {
			taskToUpdate.setName(name);
		}
		
		if (description != null) {
			taskToUpdate.setDescription(description);
		}
	}
	
	

}
