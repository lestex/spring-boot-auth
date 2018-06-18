package pro.devopslab.auth.controllers;

import org.bson.types.ObjectId;
import pro.devopslab.auth.models.Task;
import pro.devopslab.auth.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
	private TaskRepository repository;

    @GetMapping
    public List<Task> getAllTasks() {
        return repository.findAll();
	}

	@GetMapping("/{id}")
	public Task getTask(@PathVariable("id") ObjectId id) {
		return repository.findBy_id(id);
	}

	@PostMapping
	public void addTask(@RequestBody Task task) {
		task.set_id(ObjectId.get());
		repository.save(task);
	}

	@PutMapping("/{id}")
	public void editTask(@PathVariable ObjectId id, @RequestBody Task task) {
		Task existingTask = repository.findBy_id(id);
		Assert.notNull(existingTask, "Task not found");
		existingTask.setDescription(task.getDescription());
		repository.save(existingTask);
	}

	@DeleteMapping("/{id}")
	public void deleteTask(@PathVariable ObjectId id) {
		repository.delete(repository.findBy_id(id));
    }

}
