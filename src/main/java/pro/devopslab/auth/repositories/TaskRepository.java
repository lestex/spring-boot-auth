package pro.devopslab.auth.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.bson.types.ObjectId;
import pro.devopslab.auth.models.Task;

public interface TaskRepository extends MongoRepository<Task, String> {
    Task findBy_id(ObjectId _id);
}
