package design_patterns.observer_pattern.client;

import design_patterns.observer_pattern.Customer;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

    public class CustomerApp {

        public static void main(String[] args) {
            Client client = ClientBuilder.newClient();
            WebTarget target = client.
                    target("http://localhost:8080/test-1.0-SNAPSHOT/api/customers");
            postUsingRawJSON(target);
            getAllCustomers(target);
        }

        private static void getAllCustomers(WebTarget target) {
            String s = target.request().get(String.class);
            System.out.println("All customers : "+s);
        }

        private static void postUsingRawJSON(WebTarget target) {
            String customer = CustomerUtil.createCustomerInJSON("Test"
                    , "1021"
                    , "213 12");
            String response = target.request()
                    .post(Entity.entity(customer, MediaType.APPLICATION_JSON)
                            , String.class);
            System.out.println("customer created with id: "+response);

            //get the new customer
            getCustomerById(target, response);

        }

        private static void getCustomerById(WebTarget target, String response) {

            //the complete resource URI would be
            //http://localhost:8080/test-1.0-SNAPSHOT/api/customers/{newId}"
            String s = target.path(response)
                    .request()
                    .get(String.class);
            System.out.println("new customer :"+s);
        }

    }
