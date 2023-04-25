package in.happy.entity;

	import java.time.LocalDate;

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.Id;
	import javax.persistence.Table;

	import org.hibernate.annotations.CreationTimestamp;
	import org.hibernate.annotations.UpdateTimestamp;

	import lombok.Data;

	@Entity
	@Data
	@Table (name = "Plan_Category")
	public class PlanCategory {
		
		@Id
		@GeneratedValue
		@Column (name= "CategoryId")
		private Integer categoryId;
		
		@Column (name = "Category_Name")
		private String categoryName;
		
		@Column (name = " Active_Sw")
		private String activeSw;
		
		@Column (name = " Created_by")
		private String createdBy;
		
		@Column (name = " Updated_By")
		private String updatedBy;
		
		@Column (name = " Created_Date" , updatable = false)
		@CreationTimestamp
		private LocalDate createdDate;
		
		@Column (name = " Updated_Date" , insertable = false)
		@UpdateTimestamp
		private LocalDate updateDate;
		

	}




