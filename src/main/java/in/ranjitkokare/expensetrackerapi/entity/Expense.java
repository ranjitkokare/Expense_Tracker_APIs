package in.ranjitkokare.expensetrackerapi.entity;

import java.math.BigDecimal;

import java.sql.Date;
import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_expenses")
public class Expense {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "expense_name")
	@NotBlank(message = "Expense name must not be null")
	@Size(min = 3,message = "Expense name must be atleast 3 characters")
	private String name;
	
	
	private String description;
	
	@NotNull(message = "Expense amount should not be null")
	@Column(name = "expense_amount")
	private BigDecimal amount;
	
	@NotBlank(message = "Category should not be null")
	private String category;
	
	@NotNull(message = "Date must not be null")
	private Date date;
	
	@Column(name = "created_at", nullable = false, updatable = false)
	@CreationTimestamp//Hibernate Annotaion
	private Timestamp createdAt;
	
	@Column(name = "updated_at")
	@UpdateTimestamp
	private Timestamp updatedAt;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
