package in.happy.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.happy.entity.Plan;
import in.happy.entity.PlanCategory;
import in.happy.repo.PlanCategoryRepo;
import in.happy.repo.PlanRepo;

@Service
public class PlanServiceImpl implements PlanService {
	
	@Autowired
	private PlanRepo planRepo;
	
	private PlanCategoryRepo planCategoryRepo;

	@Override
	public Map<Integer, String> getPlanCategories() {
	
		List<PlanCategory> categories = planCategoryRepo.findAll();
		Map<Integer,String> categoryMap = new HashMap<>();
		
		categories.forEach(category -> {
			
			categoryMap.put(category.getCategoryId(), category.getCategoryName());
		});
		return categoryMap;
	}

	@Override
	public boolean savePlan(Plan plan) {
		 Plan saved = planRepo.save(plan);
		 
		return saved.getPlanId()!=null;
	}

	@Override
	public List<Plan> getAllplans() {
		return planRepo.findAll();
	}

	@Override
	public Plan getPlanById(Integer planId) {
		Optional<Plan> findById = planRepo.findById(planId);
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public boolean updatePlan(Plan plan) {
		 planRepo.save(plan);
		return plan.getPlanId()!=null;
	}

	@Override
	public boolean deletePlan(Integer planId) {
		
		boolean status = false;
		try {
		planRepo.deleteById(planId);
		status = true;
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	    return status;	
}

	@Override
	public boolean planStatusChange(Integer planId, String activeSw) {
		Optional<Plan> findById = planRepo.findById(planId);
		if(findById.isPresent()){
			Plan plan = findById.get();
			plan.setActiveSw(activeSw);
			return true;	
		}
		return false;
	}

}
