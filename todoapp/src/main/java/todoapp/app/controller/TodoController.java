package todoapp.app.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import todoapp.app.beans.CustomResponseBean;
import todoapp.app.beans.TodoBean;
import todoapp.app.dao.TodoDao;

@RestController
@CrossOrigin(origins="*")
public class TodoController {

	@Autowired
	TodoDao todoDao;
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	@RequestMapping("/hello")
	public String sayHello(){
		
		return "Hello";
	}
	
	@RequestMapping(value={"/todo/create","/todo/update"},method=RequestMethod.POST,consumes="application/json",produces="application/json")
	public TodoBean createTodo(@RequestBody TodoBean bean){
		
		if(null != bean && (null == bean.getStatus() || "".equals(bean.getStatus()) )){
			bean.setStatus("Pending");
		}
		
		TodoBean todoBean = todoDao.save(bean);
		return todoBean;
	}
	
	@RequestMapping(value="/todo",produces="application/json")
	public List<TodoBean> getAll(){
				
		List<TodoBean> todoBeans = todoDao.findAll();
		return todoBeans;
	}
	
	@RequestMapping(value="/todo/delete/{id}")
	public CustomResponseBean deleteById(@PathVariable("id") String id){
				
		todoDao.delete(id);
		CustomResponseBean responseBean = new CustomResponseBean();
		responseBean.setMessage("Todo deleted successfully");
		responseBean.setStatusCode(1);
		return responseBean;
	}
	
	@RequestMapping(value="/todo/{id}",produces="application/json")
	public TodoBean getById(@PathVariable("id") String id){
				
		TodoBean todoBean = todoDao.findOne(id);
		return todoBean;
	}
	
	@RequestMapping(value="/todo/delete/all")
	public CustomResponseBean deleteAll(){
				
		todoDao.deleteAll();
		CustomResponseBean responseBean = new CustomResponseBean();
		responseBean.setMessage("Todo deleted successfully");
		responseBean.setStatusCode(1);
		return responseBean;
	}
	
	@RequestMapping(value="/todo/status/{status}",produces="application/json")
	public List<TodoBean> findByStatus(@PathVariable("status") String status){
				
		Query query = new Query();
		query.addCriteria(Criteria.where("status").is(status));
		
		List<TodoBean> todoBeans = mongoTemplate.find(query, TodoBean.class);
		return todoBeans;
	}
	
	@RequestMapping(value={"/todo/markcomplete"},method=RequestMethod.POST,consumes="application/json",produces="application/json")
	public TodoBean markcompleteTodo(@RequestBody TodoBean bean){
		
		if(null != bean){
			bean.setStatus("Completed");
		}
		
		TodoBean todoBean = todoDao.save(bean);
		return todoBean;
	}

}