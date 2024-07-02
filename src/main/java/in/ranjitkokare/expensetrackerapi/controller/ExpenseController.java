package in.ranjitkokare.expensetrackerapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ranjitkokare.expensetrackerapi.entity.Expense;
import in.ranjitkokare.expensetrackerapi.service.ExpenseService;

@RestController
public class ExpenseController {
	
	@Autowired
	private ExpenseService expenseService; 
	
	@GetMapping("/expenses")
	public List<Expense> getAllExpenses() {
		return expenseService.getAllExpenses();
	}
}