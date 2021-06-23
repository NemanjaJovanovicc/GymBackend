package gym.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import gym.jpa.Payment;

public interface PaymentRepository extends JpaRepository<Payment,Integer>{
	Collection<Payment> findByAmountContainingIgnoreCase(String amount);

}
