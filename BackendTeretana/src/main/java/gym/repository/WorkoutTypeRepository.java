package gym.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import gym.jpa.WorkoutType;


public interface WorkoutTypeRepository extends JpaRepository <WorkoutType,Integer> {
	Collection<WorkoutType> findByTitleContainingIgnoreCase(String title);
}



