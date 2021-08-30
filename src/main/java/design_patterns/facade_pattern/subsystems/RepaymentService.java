package design_patterns.facade_pattern.subsystems;

import design_patterns.facade_pattern.Customer;

import javax.ejb.Stateless;

@Stateless
public class RepaymentService {
    public void setUpPaymentSchedule(Customer customer, Double principle, Integer months) {
        // set up monthly automatic payment from customer account to bank
    }

}
