package com.finwise.FinWise.controller;

import com.finwise.FinWise.model.Expense;
import com.finwise.FinWise.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping
    public List<Expense> getExpenses(@RequestParam Long userId) {
        return expenseService.getExpensesByUserId(userId);
    }

    @PostMapping
    public ResponseEntity<?> addExpense(@RequestBody Expense expense, Principal principal) {
        String username = principal.getName(); // Get the logged-in user's username
        Expense savedExpense = expenseService.addExpense(expense, username);
        return ResponseEntity.ok(savedExpense);
    }

    @PutMapping("/{id}")
    public Expense updateExpense(@PathVariable Long id, @RequestBody Expense updatedExpense) {
        return expenseService.updateExpense(id, updatedExpense);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
        return ResponseEntity.ok("Expense deleted successfully");
    }
}
