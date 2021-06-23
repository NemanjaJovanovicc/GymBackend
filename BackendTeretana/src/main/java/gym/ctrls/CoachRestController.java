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

import gym.jpa.Coach;
import gym.repository.CoachRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class CoachRestController {
	
	@Autowired
	private CoachRepository coachRepository;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@GetMapping("coach")
	public Collection<Coach>GetCoach() {
		
		return coachRepository.findAll();
	
	}
	
	@GetMapping("coach/{id}")
	 public Coach getCoach (@PathVariable("id") Integer id) {
		 return coachRepository.getOne(id);
	 }
	
	@GetMapping("coachName/{name}")
	public Collection<Coach> getCoachByName (@PathVariable("name") String name){
		 return coachRepository.findByNameContainingIgnoreCase(name);
	}
	
	@PostMapping("coach")
	public ResponseEntity<Coach> insertCoach(@RequestBody Coach coach) {
		if(!coachRepository.existsById(coach.getId())) {
			coachRepository.save(coach);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}
	
	@PutMapping("coach")
	public ResponseEntity<Coach> updateCoach(@RequestBody Coach coach) {
		if(!coachRepository.existsById(coach.getId())) 
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		coachRepository.save(coach);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	@DeleteMapping("coach/{id}")
	public ResponseEntity<Coach> deleteCoach(@PathVariable ("id") Integer id) {
		if(!coachRepository.existsById(id)) 
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		coachRepository.deleteById(id);
		if(id == -100)
			jdbcTemplate.execute(
					" insert into \"coach\" (\"id\", \"name\", \"surname\", \"jmbg\", \"adress\", \"contact\")"
					+ " values (-100,'name TEST','surname TEST','TEST','TEST','TEST') ");
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
}
