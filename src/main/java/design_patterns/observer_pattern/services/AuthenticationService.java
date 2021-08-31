package design_patterns.observer_pattern.services;

import design_patterns.observer_pattern.Customer;

import javax.enterprise.event.Observes;

public class AuthenticationService {

    // inject the event called customer
    public void createAuthenticationCredentials(@Observes Customer customer){
        // create authentication credentials
    }
}
