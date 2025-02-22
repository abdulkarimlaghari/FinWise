package com.finwise.FinWise.repository;

import com.finwise.FinWise.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByUserId(Long userId); // Find expense by User ID
}
