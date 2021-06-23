package gym.jpa;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * The persistent class for the gym_card database table.
 * 
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="gym_card")
@NamedQuery(name="GymCard.findAll", query="SELECT g FROM GymCard g")
public class GymCard implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="GYM_CARD_ID_GENERATOR", sequenceName="GYM_CARD_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GYM_CARD_ID_GENERATOR")
	private Integer id;

	private String cardduration;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="employee")
	private Employee employee;

	//bi-directional many-to-one association to Member
	@ManyToOne
	@JoinColumn(name="member")
	private Member member;

	public GymCard() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCardduration() {
		return this.cardduration;
	}

	public void setCardduration(String cardduration) {
		this.cardduration = cardduration;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Member getMember() {
		return this.member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

}