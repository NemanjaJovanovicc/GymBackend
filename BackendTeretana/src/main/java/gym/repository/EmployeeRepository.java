package gym.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import gym.jpa.Employee;

public interface EmployeeRepository extends JpaRepository <Employee,Integer> {
	Collection<Employee> findByNameContainingIgnoreCase(String name);
}
