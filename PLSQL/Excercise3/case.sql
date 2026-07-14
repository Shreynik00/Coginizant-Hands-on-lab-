DELIMITER //

CREATE PROCEDURE ProcessMonthlyInterest()
BEGIN
    UPDATE Accounts
    SET Balance = Balance + (Balance * 0.01)
    WHERE AccountType = 'Savings';
END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE UpdateEmployeeBonus(
    IN dept_name VARCHAR(50),
    IN bonus_percentage DECIMAL(5,2)
)
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * bonus_percentage / 100)
    WHERE Department = dept_name;
END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE TransferFunds(
    IN from_account INT,
    IN to_account INT,
    IN transfer_amount DECIMAL(10,2)
)
BEGIN

    DECLARE source_balance DECIMAL(10,2);

    -- Get source account balance
    SELECT Balance 
    INTO source_balance
    FROM Accounts
    WHERE AccountID = from_account;


    -- Check sufficient balance
    IF source_balance >= transfer_amount THEN

        UPDATE Accounts
        SET Balance = Balance - transfer_amount
        WHERE AccountID = from_account;


        UPDATE Accounts
        SET Balance = Balance + transfer_amount
        WHERE AccountID = to_account;


    ELSE

        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Insufficient Balance';

    END IF;

END //

DELIMITER ;
