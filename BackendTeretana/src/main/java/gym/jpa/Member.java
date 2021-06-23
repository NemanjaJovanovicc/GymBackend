package gym.jpa;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


/**
 * The persistent class for the member database table.
 * 
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NamedQuery(name="Member.findAll", query="SELECT m FROM Member m")
public class Member implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MEMBER_ID_GENERATOR", sequenceName="MEMBER_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MEMBER_ID_GENERATOR")
	private Integer id;

	private String adress;

	private String contact;

	private String jmbg;

	private String name;

	private String status;

	private String surname;

	//bi-directional many-to-one association to GymCard
	@JsonIgnore
	@OneToMany(mappedBy="member")
	private List<GymCard> gymCards;

	//bi-directional many-to-one association to CardCategory

	@ManyToOne
	@JoinColumn(name="cardcategory")
	private CardCategory cardCategory;

	//bi-directional many-to-one association to Payment
	@ManyToOne
	@JoinColumn(name="payment")
	private Payment payment;

	//bi-directional many-to-one association to Workout
	@JsonIgnore
	@OneToMany(mappedBy="member")
	private List<Workout> workouts;

	public Member() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAdress() {
		return this.adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getJmbg() {
		return this.jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<GymCard> getGymCards() {
		return this.gymCards;
	}

	public void setGymCards(List<GymCard> gymCards) {
		this.gymCards = gymCards;
	}

	public GymCard addGymCard(GymCard gymCard) {
		getGymCards().add(gymCard);
		gymCard.setMember(this);

		return gymCard;
	}

	public GymCard removeGymCard(GymCard gymCard) {
		getGymCards().remove(gymCard);
		gymCard.setMember(null);

		return gymCard;
	}

	public CardCategory getCardCategory() {
		return this.cardCategory;
	}

	public void setCardCategory(CardCategory cardCategory) {
		this.cardCategory = cardCategory;
	}

	public Payment getPayment() {
		return this.payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public List<Workout> getWorkouts() {
		return this.workouts;
	}

	public void setWorkouts(List<Workout> workouts) {
		this.workouts = workouts;
	}

	public Workout addWorkout(Workout workout) {
		getWorkouts().add(workout);
		workout.setMember(this);

		return workout;
	}

	public Workout removeWorkout(Workout workout) {
		getWorkouts().remove(workout);
		workout.setMember(null);

		return workout;
	}

}