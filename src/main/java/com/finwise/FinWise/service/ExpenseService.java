package com.finwise.FinWise.service;

import com.finwise.FinWise.model.Expense;
import com.finwise.FinWise.model.User;
import com.finwise.FinWise.repository.ExpenseRepository;
import com.finwise.FinWise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private UserRepository userRepository;
//
//    public List<Expense> getExpensesByUserId(Long userId) {
//        return expenseRepository.findByUserId(userId);
//    }

    public Expense addExpense(Expense expense, String username) {
        // Fetch user by username
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Assign user to expense
        expense.setUser(user);

        return expenseRepository.save(expense);
    }

    public List<Expense> getExpensesByUsername(String username) {
        return expenseRepository.findByUser_Username(username);
    }

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public List<Expense> getExpensesByUserId(Long userId) {
        return expenseRepository.findByUser_Id(userId);
    }




    public Expense updateExpense(Long id, Expense updatedExpense) {
        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found"));
        expense.setDescription(updatedExpense.getDescription());
        expense.setAmount(updatedExpense.getAmount());
        expense.setDate(updatedExpense.getDate());
        expense.setCategory(updatedExpense.getCategory());
        return expenseRepository.save(expense);
    }

    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }
}
