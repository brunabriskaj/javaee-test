package design_patterns.facade_pattern.subsystems;

import design_patterns.facade_pattern.Customer;

import javax.ejb.Stateless;

@Stateless
public class TransferService {
    public void makeTransfer(Double principle, Customer customer) {
        // Transfer principle to customer bank account
    }
}
