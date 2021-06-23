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

import gym.jpa.Member;
import gym.repository.MemberRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class MemberRestController {
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@GetMapping("member")
	public Collection<Member>GetMember() {
		
		return memberRepository.findAll();
	
	}
	
	@GetMapping("member/{id}")
	 public Member getMember (@PathVariable("id") Integer id) {
		 return memberRepository.getOne(id);
	 }
	
	@GetMapping("memberName/{name}")
	public Collection<Member> getMemberByName (@PathVariable("name") String name){
		 return memberRepository.findByNameContainingIgnoreCase(name);
	}
	
	@PostMapping("member")
	public ResponseEntity<Member> insertMember(@RequestBody Member member) {
		if(!memberRepository.existsById(member.getId())) {
			memberRepository.save(member);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}
	
	@PutMapping("member")
	public ResponseEntity<Member> updateMember(@RequestBody Member member) {
		if(!memberRepository.existsById(member.getId())) 
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		memberRepository.save(member);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	@DeleteMapping("member/{id}")
	public ResponseEntity<Member> deleteMember(@PathVariable ("id") Integer id) {
		if(!memberRepository.existsById(id)) 
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		memberRepository.deleteById(id);
		if(id == -100)
			jdbcTemplate.execute(
					"insert into \"member\" (\"id\", \"name\", \"surname\", \"jmbg\", \"adress\", \"contact\", \"status\", \"cardcategory\", \"payment\")"
					+ " values (-100,'name TEST','surname TEST','jmbg TEST','addres TEST','contact TEST','status TEST',201,101) ");
		return new ResponseEntity<>(HttpStatus.OK);
	}
}

