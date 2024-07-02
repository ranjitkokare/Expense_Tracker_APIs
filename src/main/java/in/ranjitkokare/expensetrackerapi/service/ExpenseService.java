package in.ranjitkokare.expensetrackerapi.service;

import java.util.List;

import in.ranjitkokare.expensetrackerapi.entity.Expense;

public interface ExpenseService {
	
	List<Expense> getAllExpenses();
}
