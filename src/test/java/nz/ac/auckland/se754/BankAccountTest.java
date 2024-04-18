package nz.ac.auckland.se754;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountTest {

    private BankAccount bank;

    @BeforeEach
    public void setUp() {
        bank = new BankAccount();
    }

    @Test
    public void test1() {
        bank.deposit(10.00);
        double balance = bank.getBalance();
        assertEquals(10, balance);

    }

    @Test
    public void test2() {
        bank.deposit(100.00);
        bank.withdraw(10.00);
        double balance = bank.getBalance();
        assertEquals(90, balance);

    }

    @Test
    public void test3() {
        bank.deposit(10.00);
        bank.withdraw(5.00);
        double balance = bank.getBalance();
        assertEquals(5, balance);

    }

    @Test
    public void test4() {

        assertThrows(BalanceNotEnoughException.class, () -> {
            bank.withdraw(10);
        });
    }

}