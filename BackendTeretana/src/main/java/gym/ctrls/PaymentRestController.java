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

import gym.jpa.Payment;
import gym.repository.PaymentRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class PaymentRestController {
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@GetMapping("payment")
	public Collection<Payment>GetPayment() {
		
		return paymentRepository.findAll();
	
	}
	
	@GetMapping("payment/{id}")
	 public Payment getPayment (@PathVariable("id") Integer id) {
		 return paymentRepository.getOne(id);
	 }
	
	@GetMapping("paymentAmount/{amount}")
	public Collection<Payment> getPaymentByAmount (@PathVariable("amount") String amount){
		 return paymentRepository.findByAmountContainingIgnoreCase(amount);
	}
	
	@PostMapping("payment")
	public ResponseEntity<Payment> insertPayment(@RequestBody Payment payment) {
		if(!paymentRepository.existsById(payment.getId())) {
			paymentRepository.save(payment);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}
	
	@PutMapping("payment")
	public ResponseEntity<Payment> updatePayment(@RequestBody Payment payment) {
		if(!paymentRepository.existsById(payment.getId())) 
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		paymentRepository.save(payment);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	@DeleteMapping("payment/{id}")
	public ResponseEntity<Payment> deletePayment(@PathVariable ("id") Integer id) {
		if(!paymentRepository.existsById(id)) 
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		paymentRepository.deleteById(id);
		if (id == -100)
			jdbcTemplate.execute(
					" insert into \"payment\" (\"id\", \"amount\", \"paymentdate\")"
					+ " values (-100,'Test dinara','datum test') ");
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
