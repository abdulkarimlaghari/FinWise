-- Insert Sample Users
INSERT INTO users (username, email, password) VALUES
('john_doe', 'john@example.com', '$2a$10$xyz'),
('jane_doe', 'jane@example.com', '$2a$10$abc');

-- Insert Sample Expenses
INSERT INTO expenses (description, amount, date, category, user_id) VALUES
('Groceries', 150.00, '2025-02-10', 'Food', 1),
('Electricity Bill', 75.50, '2025-02-12', 'Utilities', 2);
