package design_patterns.facade_pattern.subsystems;

import design_patterns.facade_pattern.Customer;

import javax.ejb.Stateless;

@Stateless
public class InternalBankPolicyService {
    public boolean checkCompliance(Customer customer) {
        // Check that customer conforms to bank policy on lending
        return true;
    }
}
