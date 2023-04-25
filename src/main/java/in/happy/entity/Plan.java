package in.happy.entity;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table (name = "Plan_Master")
public class Plan {
	
	@Id
	@GeneratedValue
	@Column (name = "Plan_Id")
	private Integer planId;
	
	@Column (name = " Plan_Name")
	private String planName;
	
	@Column (name = "Plan_Start_Date")
	private LocalDate planStartDate;
	
	@Column (name = "Plan_End_On")
	private LocalDate planEndDate;
	
	@Column (name = "Plan_Category_id")
	private Integer categoryId;
	
	@Column (name = "Plan_Created_By")
	private String createdBy;
	
	@Column (name = "Plan_Updated_By")
	private String updatedBy;

	@Column (name = "Active_Sw")
	private String activeSw;
	
	@Column (name = "Created_Date",updatable=false)
	private LocalDate createdDate;
	
}
