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

import gym.jpa.CardCategory;
import gym.repository.CardCategoryRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class CardCategoryRestController {
	
	@Autowired
	private CardCategoryRepository cardCategoryRepository;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@GetMapping("cardCategory")
	public Collection<CardCategory>GetCardCategory() {
		
		return cardCategoryRepository.findAll();
	
	}
	
	@GetMapping("cardCategory/{id}")
	 public CardCategory getCardCategory (@PathVariable("id") Integer id) {
		 return cardCategoryRepository.getOne(id);
	 }
	
	@GetMapping("cardCategoryName/{name}")
	public Collection<CardCategory> getCardCategoryByName (@PathVariable("name") String name){
		 return cardCategoryRepository.findByNameContainingIgnoreCase(name);
	}
	
	@PostMapping("cardCategory")
	public ResponseEntity<CardCategory> insertCardCategory(@RequestBody CardCategory cardCategory) {
		if(!cardCategoryRepository.existsById(cardCategory.getId())) {
			cardCategoryRepository.save(cardCategory);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}
	
	@PutMapping("cardCategory")
	public ResponseEntity<CardCategory> updateCardCategory(@RequestBody CardCategory cardCategory) {
		if(!cardCategoryRepository.existsById(cardCategory.getId())) 
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		cardCategoryRepository.save(cardCategory);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	@DeleteMapping("cardCategory/{id}")
	public ResponseEntity<CardCategory> deleteCardCategory(@PathVariable ("id") Integer id) {
		if(!cardCategoryRepository.existsById(id)) 
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		cardCategoryRepository.deleteById(id);
		if (id == -100)
			jdbcTemplate.execute(
					" insert into \"card_category\" (\"id\", \"name\", \"description\", \"mark\")"
					+ " values (-100,'name TEST','description TEST','mark TEST') ");
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
