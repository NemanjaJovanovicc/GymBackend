package gym.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import gym.jpa.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {
	Collection<Member> findByNameContainingIgnoreCase(String name);

}
