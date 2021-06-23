package gym.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import gym.jpa.CardCategory;


public interface CardCategoryRepository extends JpaRepository<CardCategory, Integer> {
	Collection<CardCategory> findByNameContainingIgnoreCase(String name);

}
