package in.happy.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.happy.entity.Plan;
import in.happy.service.PlanService;

@RestController
public class PlanRestController {
	
	@Autowired
	private PlanService planService;
	
	@GetMapping("/Categories")
	public ResponseEntity<Map<Integer,String>> planCategories(){
		 
		Map<Integer, String> categories = planService.getPlanCategories();
		return new ResponseEntity<>(categories, HttpStatus.OK);
	}
	
	@PostMapping("/plan")
	public ResponseEntity<String> savePlan(@RequestBody Plan plan){
		
		String msg = "";
		boolean isSaved = planService.savePlan(plan);
		if(isSaved) {
			msg = "message saved";
		}else
			msg = "message not saved";
		return new ResponseEntity<>(msg,HttpStatus.ACCEPTED);
	}
	
	@GetMapping ("/plans")
	public ResponseEntity<List<Plan>> plans(){
		
		List<Plan> allplans = planService.getAllplans();
		return new ResponseEntity<>(allplans, HttpStatus.OK);
	}
	
	@GetMapping ("/plan/{planId}")
	public ResponseEntity<Plan> editPlan(@PathVariable Integer planId){
		
		Plan planById = planService.getPlanById(planId);
		return new ResponseEntity<>(planById,HttpStatus.OK);
	}
	
	@DeleteMapping("/plan/{planId}")
	public ResponseEntity<String> deletePlan(@PathVariable Integer planId){
		
		boolean isDelete = planService.deletePlan(planId);
		String msg="";
		if(isDelete) {
			msg ="plan Deleted";	
		}else {
			msg = "plan not Deleted";
		}
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
    
	@PutMapping ("/plan")
	public ResponseEntity<String> updatePlan(@RequestBody Plan Plan){
		
		boolean isUpdate = planService.updatePlan(Plan);
		String msg="";
		if(isUpdate) {
			msg ="plan Updated";	
		}else {
			msg = "plan not Updated";
		}
		return new ResponseEntity<>(msg,HttpStatus.OK);
    }
	
	@PutMapping("/status-changed/{planId}/{activeSw}")
	public ResponseEntity<String> statusChage(@PathVariable Integer PlanId,@PathVariable String activeSw){
		String msg="";
		boolean isStatusChange = planService.planStatusChange(PlanId, activeSw);
		if(isStatusChange) {
			msg = "status changed";
		}else {
			msg = "status not chaged";
		}
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
}
