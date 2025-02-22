package com.finwise.FinWise.repository;

import com.finwise.FinWise.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    // ✅ Find expenses by user ID
    List<Expense> findByUser_Id(Long userId);

    // ✅ Find expenses by username
    List<Expense> findByUser_Username(String username);
}
