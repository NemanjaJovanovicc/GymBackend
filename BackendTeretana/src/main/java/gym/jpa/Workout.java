package gym.jpa;

import java.io.Serializable;
import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * The persistent class for the workout database table.
 * 
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NamedQuery(name="Workout.findAll", query="SELECT w FROM Workout w")
public class Workout implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="WORKOUT_ID_GENERATOR", sequenceName="WORKOUT_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="WORKOUT_ID_GENERATOR")
	private Integer id;

	private String date;

	private String duration;

	//bi-directional many-to-one association to Coach
	@ManyToOne
	@JoinColumn(name="coach")
	private Coach coach;

	//bi-directional many-to-one association to Member
	@ManyToOne
	@JoinColumn(name="member")
	private Member member;

	//bi-directional many-to-one association to WorkoutType
	@ManyToOne
	@JoinColumn(name="workouttype")
	private WorkoutType workoutType;

	public Workout() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDuration() {
		return this.duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Coach getCoach() {
		return this.coach;
	}

	public void setCoach(Coach coach) {
		this.coach = coach;
	}

	public Member getMember() {
		return this.member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public WorkoutType getWorkoutType() {
		return this.workoutType;
	}

	public void setWorkoutType(WorkoutType workoutType) {
		this.workoutType = workoutType;
	}

}