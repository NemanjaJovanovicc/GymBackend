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

import gym.jpa.Workout;
import gym.repository.WorkoutRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class WorkoutRestController {
	
	@Autowired
	private WorkoutRepository workoutRepository;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@GetMapping("workout")
	public Collection<Workout>GetWorkout() {
		
		return workoutRepository.findAll();
	
	}
	
	@GetMapping("workout/{id}")
	 public Workout getWorkout (@PathVariable("id") Integer id) {
		 return workoutRepository.getOne(id);
	 }
	
	@GetMapping("workoutDate/{date}")
	public Collection<Workout> getWorkoutByDate (@PathVariable("date") String date){
		 return workoutRepository.findByDateContainingIgnoreCase(date);
	}
	
	@PostMapping("workout")
	public ResponseEntity<Workout> insertWorkout(@RequestBody Workout workout) {
		if(!workoutRepository.existsById(workout.getId())) {
			workoutRepository.save(workout);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}
	
	@PutMapping("workout")
	public ResponseEntity<Workout> updateWorkout(@RequestBody Workout workout) {
		if(!workoutRepository.existsById(workout.getId())) 
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		workoutRepository.save(workout);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	@DeleteMapping("workout/{id}")
	public ResponseEntity<Workout> deleteWorkout(@PathVariable ("id") Integer id) {
		if(!workoutRepository.existsById(id)) 
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		workoutRepository.deleteById(id);
		if (id == -100)
			jdbcTemplate.execute(
					"insert into \"workout\" (\"id\", \"duration\", \"date\", \"workouttype\", \"coach\", \"member\") "
					+ "values (-100,'duration TEST','date TEST','51','451','1001') ");
		return new ResponseEntity<>(HttpStatus.OK);
	}
}

