package design_patterns.observer_pattern.services;

import design_patterns.observer_pattern.Customer;

import javax.annotation.Priority;
import javax.enterprise.event.Observes;

public class EmailService {

    public void sendWelcomeEmail(@Observes Customer customer) {
        // send welcome email
    }
}
