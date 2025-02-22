package com.finwise.FinWise.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "expenses")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Getter
    @Column(nullable = false)
    private String description;

    @Setter
    @Getter
    @Column(nullable = false)
    private double amount;

    @Setter
    @Getter
    @Column(nullable = false)
    private LocalDate date;

    @Setter
    @Getter
    @Column(nullable = false)
    private String category;

    // Add getter and setter for User
    @Setter
    @Getter
    @ManyToOne(fetch = FetchType.LAZY) // LAZY Loading for optimise performance
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore // prevent circular dependency issues
    private User user; // Link the expense to a user

}
