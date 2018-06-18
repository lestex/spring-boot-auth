package pro.devopslab.auth.repositories;

import pro.devopslab.auth.models.ApplicationUser;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<ApplicationUser, String> {
    ApplicationUser findBy_id(ObjectId _id);
    ApplicationUser findByUsername(String username);
}