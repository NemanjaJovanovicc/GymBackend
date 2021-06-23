package gym.ctrls;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import gym.jpa.Employee;
import gym.repository.EmployeeRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class EmployeeRestController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@GetMapping("employee")
	public Collection<Employee>GetEmployee() {
		
		return employeeRepository.findAll();
	
	}
	
	@GetMapping("employee/{id}")
	 public Employee getEmployee (@PathVariable("id") Integer id) {
		 return employeeRepository.getOne(id);
	 }
	
	@GetMapping("employeeName/{name}")
	public Collection<Employee> getEmployeeByName (@PathVariable("name") String name){
		 return employeeRepository.findByNameContainingIgnoreCase(name);
	}
	
	@PostMapping("employee")
	public ResponseEntity<Employee> insertEmployee(@RequestBody Employee employee) {
		if(!employeeRepository.existsById(employee.getId())) {
			employeeRepository.save(employee);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}
	
	@PutMapping("employee")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		if(!employeeRepository.existsById(employee.getId())) 
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		employeeRepository.save(employee);
		return new ResponseEntity<>(HttpStatus.OK);
		
	} 
	
	@DeleteMapping("employee/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable ("id") Integer id) {
		if(!employeeRepository.existsById(id)) 
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		employeeRepository.deleteById(id);
		if (id == -100)
			jdbcTemplate.execute(
					" insert into \"employee\" (\"id\", \"username\", \"password\", \"name\", \"surname\", \"contact\")"
					+ "values (-100,'username TEST','password TEST','name TEST','surname TEST','contact TEST') ");
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/*
	@GetMapping("employee/{id}")
	 public ResponseEntity<Employee> getEmployeeById (@PathVariable Long id) {
		 Employee employee = employeeRepository.findById(id)
				 .orElseThrow(() -> new ResourceNotFoundException("Employee not exists with id :" + id));
		 return ResponseEntity.ok(employee);
	 }
	*/

}
