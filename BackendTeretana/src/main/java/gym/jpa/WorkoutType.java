package gym.jpa;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


/**
 * The persistent class for the workout_type database table.
 * 
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="workout_type")
@NamedQuery(name="WorkoutType.findAll", query="SELECT w FROM WorkoutType w")
public class WorkoutType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="WORKOUT_TYPE_ID_GENERATOR", sequenceName="WORKOUT_TYPE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="WORKOUT_TYPE_ID_GENERATOR")
	private Integer id;

	private String title;

	//bi-directional many-to-one association to Workout
	@JsonIgnore
	@OneToMany(mappedBy="workoutType")
	private List<Workout> workouts;

	public WorkoutType() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Workout> getWorkouts() {
		return this.workouts;
	}

	public void setWorkouts(List<Workout> workouts) {
		this.workouts = workouts;
	}

	public Workout addWorkout(Workout workout) {
		getWorkouts().add(workout);
		workout.setWorkoutType(this);

		return workout;
	}

	public Workout removeWorkout(Workout workout) {
		getWorkouts().remove(workout);
		workout.setWorkoutType(null);

		return workout;
	}

}