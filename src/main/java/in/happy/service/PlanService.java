package in.happy.service;

import java.util.List;
import java.util.Map;

import in.happy.entity.Plan;

public interface PlanService {
	
	// for Drop down list of all plan categories by there id
	public Map<Integer,String> getPlanCategories();
	
	// for submit the plan write in database using Plan object
	public boolean savePlan(Plan plan);
	
	// for view all plan in view plan
	public List<Plan> getAllplans();
	
	// for update plan get it by integer plan id
	public Plan getPlanById(Integer planId);
	
	// for save the updated plan using Plan object
	public boolean updatePlan(Plan plan);
	
	// delete plan using plan id
	public boolean deletePlan(Integer planId);
	
	// for activate and deactivate the plan in drop down menu 
	public boolean planStatusChange( Integer planId , String activeSw  );
	
	

}
