package design_patterns.observer_pattern.api;

import design_patterns.observer_pattern.Customer;
import design_patterns.observer_pattern.services.CustomerDataService;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Here are the resource endpoints; add a path to this: customers.
 *
 * Injected an event of type Customer.
 *
 * If newCustomer is called then any observer observing for customer events will receive the customer instance.
 *
 * When the request is POST, this method will be executed => what this mean is that whenever
 * a new customer signs up on the website three services are provoked, in a very decoupled way.
 *
 */
@Stateless
@Path("/customers")
public class CustomerRestService {

    private CustomerDataService dataService = CustomerDataService.getInstance();

    @Inject // @CustomerEvent(CustomerEvent.Type.ADD)
    private Event<Customer> customerAddEvent;

    @Inject //  @CustomerEvent(CustomerEvent.Type.REMOVE)
    private Event<Customer> customerRemoveEvent;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> getCustomers() {
        return dataService.getCustomerList();
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String createCustomer(Customer newCustomer) {
        return dataService.addCustomer(newCustomer);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer getCustomer(@PathParam("id") String id) {
        return dataService.getCustomerById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void newCustomer(Customer customer) {
        customerAddEvent.fire(customer);
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public void removeCustomer(Customer customer) {
        customerRemoveEvent.fire(customer);
    }
}
