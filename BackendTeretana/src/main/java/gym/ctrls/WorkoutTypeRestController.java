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

import gym.jpa.WorkoutType;
import gym.repository.WorkoutTypeRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class WorkoutTypeRestController {
	
	@Autowired
	private WorkoutTypeRepository workoutTypeRepository;
	
	@Autowired
	private JdbcTemplate jbdcTemplate;
	
	
	@GetMapping("workoutType")
	public Collection<WorkoutType>GetWorkoutType() {
		
		return workoutTypeRepository.findAll();
	
	}
	
	@GetMapping("workoutType/{id}")
	 public WorkoutType getWorkoutType (@PathVariable("id") Integer id) {
		 return workoutTypeRepository.getOne(id);
	 }
	
	@GetMapping("workoutTypeTitle/{title}")
	public Collection<WorkoutType> getWorkoutTypeByTitle (@PathVariable("title") String title){
		 return workoutTypeRepository.findByTitleContainingIgnoreCase(title);
	}
	
	@PostMapping("workoutType")
	public ResponseEntity<WorkoutType> insertWorkoutType(@RequestBody WorkoutType workoutType) {
		if(!workoutTypeRepository.existsById(workoutType.getId())) {
			workoutTypeRepository.save(workoutType);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}
	
	@PutMapping("workoutType")
	public ResponseEntity<WorkoutType> updateWorkoutType(@RequestBody WorkoutType workoutType) {
		if(!workoutTypeRepository.existsById(workoutType.getId())) 
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		workoutTypeRepository.save(workoutType);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	@DeleteMapping("workoutType/{id}")
	public ResponseEntity<WorkoutType> deleteWorkoutType(@PathVariable ("id") Integer id) {
		if(!workoutTypeRepository.existsById(id)) 
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		workoutTypeRepository.deleteById(id);
		if(id == -100)
			jbdcTemplate.execute(
					" insert into \"workout_type\" (\"id\", \"title\")"
					+ " values (-100,'dziu dzica TEST') ");
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
