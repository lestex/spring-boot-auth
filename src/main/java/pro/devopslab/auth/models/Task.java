package pro.devopslab.auth.models;

import org.springframework.data.annotation.Id;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tasks")
public class Task {
	
	@Id
	private ObjectId _id;

	private String description;

    protected Task() { }
    
    protected Task(ObjectId _id, String description) { 
        this._id = _id;
        this.description = description;
    }

	public String get_id() {
		return _id.toHexString();
	}

	public void set_id(ObjectId _id) { 
		this._id = _id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
