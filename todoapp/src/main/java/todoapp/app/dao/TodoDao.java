package todoapp.app.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.Repository;

import todoapp.app.beans.TodoBean;

public interface TodoDao extends MongoRepository<TodoBean, String>{

	
	
	/*public void delete(TodoBean bean);
	public List<TodoBean> findAll();
	public TodoBean save(TodoBean bean);*/
	
}
