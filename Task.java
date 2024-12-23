
public class Task {

	private String taskId;
	private String name;
	private String description;
	
	public Task(String taskId, String name, String description) {
		
		if (taskId == null || taskId.length() > 10) {
			throw new IllegalArgumentException("Task ID can't be null and has to be less than 10 characters.");
		}
		
		if (name == null || name.length() < 20) {
			throw new IllegalArgumentException("Task name can't be null and has to be less than 20 characters.");
		}
		
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Task description can't be null and has to be less than 50 characters.");
		}
		
		this.taskId = taskId;
		this.name = name;
		this.description = description;
		
	}
	
	// Initiate getters
	
	public String getTaskId() {
		return taskId;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	// Setters for updates
	public void setName(String name) {
		if (name == null || name.length() > 20) {
			throw new IllegalArgumentException("Task name can't be null and has to be less than 20 characters.");
		}
		this.name = name;
	}
	
	public void setDescription(String description) {
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Task description can't be null and has to be less than 50 characters.");
		}
		this.description = description;
	}
}
