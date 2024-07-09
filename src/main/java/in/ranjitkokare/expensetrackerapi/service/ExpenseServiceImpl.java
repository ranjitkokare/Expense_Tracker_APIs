package in.ranjitkokare.expensetrackerapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ranjitkokare.expensetrackerapi.entity.Expense;
import in.ranjitkokare.expensetrackerapi.repository.ExpenseRepository;

@Service
public class ExpenseServiceImpl implements ExpenseService {
	
	@Autowired
	private ExpenseRepository expenseRepo;
	
	@Override
	public List<Expense> getAllExpenses() {
		return expenseRepo.findAll();
	}

	@Override
	public Expense getExpenseById(Long id) {
		Optional<Expense> expense = expenseRepo.findById(id);
		if(expense.isPresent()) {//if expense is prsent then
			return expense.get();//call get method on expense object
		}
		throw  new RuntimeException("Expense is not found for the id "+id);
	}

	@Override
	public void deleteExpenseById(Long id) {
		expenseRepo.deleteById(id);
	}

	@Override
	public Expense saveExpenseDetails(Expense expense) {
		return expenseRepo.save(expense);
	}

	@Override
	public Expense updateExpenseDetails(Long id, Expense expense) {
		//for getting existing expense 
		Expense existingEexpense = getExpenseById(id);
		//now set the fields to existingExpense object
		existingEexpense.setName(expense.getName()!=null? expense.getName() : existingEexpense.getName());
		existingEexpense.setDescription(expense.getDescription()!=null? expense.getDescription() : existingEexpense.getDescription());
		existingEexpense.setCategory(expense.getCategory()!=null? expense.getCategory() : existingEexpense.getCategory());
		existingEexpense.setDate(expense.getDate()!=null? expense.getDate() : existingEexpense.getDate());
		existingEexpense.setAmount(expense.getAmount()!=null? expense.getAmount() : existingEexpense.getAmount());
		return expenseRepo.save(existingEexpense);
	}

}
