package gym.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import gym.jpa.GymCard;


public interface GymCardRepository extends JpaRepository<GymCard,Integer> {
	Collection<GymCard> findBycarddurationContainingIgnoreCase(String cardduration);

}


