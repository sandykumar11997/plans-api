package in.happy.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.happy.entity.Plan;

public interface PlanRepo extends JpaRepository<Plan, Integer> {
	
	// By using JpaRepository planRepo will communicate with data base 
	//USING Abstract methods in JpaRepository interface
	//communicating with plan master database

}
