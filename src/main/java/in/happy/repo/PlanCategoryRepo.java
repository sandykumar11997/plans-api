package in.happy.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.happy.entity.PlanCategory;

public interface PlanCategoryRepo extends JpaRepository <PlanCategory,Integer>{
	
	// By using JpaRepository planRepo will communicate with data base 
		//USING Abstract methods in JpaRepository interface
		//communicating with plan category database
	
	
	

}
