package gym.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;


import gym.jpa.Workout;

public interface WorkoutRepository extends JpaRepository<Workout,Integer> {
	Collection<Workout> findByDateContainingIgnoreCase(String date);

}
