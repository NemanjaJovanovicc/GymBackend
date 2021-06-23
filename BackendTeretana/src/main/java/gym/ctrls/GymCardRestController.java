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

import gym.jpa.GymCard;

import gym.repository.GymCardRepository;


@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class GymCardRestController {
	
	@Autowired
	private GymCardRepository gymCardRepository;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@GetMapping("gymCard")
	public Collection<GymCard>GetGymCard() {
		
		return gymCardRepository.findAll();
	
	}
	
	@GetMapping("gymCard/{id}")
	 public GymCard getGymCard (@PathVariable("id") Integer id) {
		 return gymCardRepository.getOne(id);
	 }
	
	@GetMapping("gymCardDuration/{cardduration}")
	public Collection<GymCard> getGymCardByCardDuration (@PathVariable("cardduration") String cardduration){
		 return gymCardRepository.findBycarddurationContainingIgnoreCase(cardduration);
	}
	
	@PostMapping("gymCard")
	public ResponseEntity<GymCard> insertGymCard(@RequestBody GymCard gymCard) {
		if(!gymCardRepository.existsById(gymCard.getId())) {
			gymCardRepository.save(gymCard);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}
	
	@PutMapping("gymCard")
	public ResponseEntity<GymCard> updateGymCard(@RequestBody GymCard gymCard) {
		if(!gymCardRepository.existsById(gymCard.getId())) 
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		gymCardRepository.save(gymCard);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	@DeleteMapping("gymCard/{id}")
	public ResponseEntity<GymCard> deleteGymCard(@PathVariable ("id") Integer id) {
		if(!gymCardRepository.existsById(id)) 
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		gymCardRepository.deleteById(id);
		if (id == -100)
			jdbcTemplate.execute(
					"insert into \"gym_card\" (\"id\", \"cardduration\", \"employee\", \"member\") "
					+ "values (-100,'card TEST','1','101') ");
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
