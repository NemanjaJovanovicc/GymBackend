package gym.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import gym.jpa.Coach;

public interface CoachRepository extends JpaRepository <Coach,Integer> {
	Collection<Coach> findByNameContainingIgnoreCase(String name);
}

