package design_patterns.facade_pattern.subsystems;

import design_patterns.facade_pattern.Customer;

import javax.ejb.Stateless;

@Stateless
public class CreditRatingService {
    public boolean checkCustomerRating(Customer customer) {
        Integer rating = 900; // Connect to external credit reference agency
        return rating > 700;
    }
}
