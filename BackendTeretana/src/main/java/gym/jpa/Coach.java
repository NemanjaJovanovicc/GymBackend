package gym.jpa;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


/**
 * The persistent class for the coach database table.
 * 
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NamedQuery(name="Coach.findAll", query="SELECT c FROM Coach c")
public class Coach implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COACH_ID_GENERATOR", sequenceName="COACH_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COACH_ID_GENERATOR")
	private Integer id;

	private String adress;

	private String contact;

	private String jmbg;

	private String name;

	private String surname;

	//bi-directional many-to-one association to Workout
	@JsonIgnore
	@OneToMany(mappedBy="coach")
	private List<Workout> workouts;

	public Coach() {
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

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<Workout> getWorkouts() {
		return this.workouts;
	}

	public void setWorkouts(List<Workout> workouts) {
		this.workouts = workouts;
	}

	public Workout addWorkout(Workout workout) {
		getWorkouts().add(workout);
		workout.setCoach(this);

		return workout;
	}

	public Workout removeWorkout(Workout workout) {
		getWorkouts().remove(workout);
		workout.setCoach(null);

		return workout;
	}

}