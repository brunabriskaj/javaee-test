package design_patterns.interceptor_pattern;

import javax.ejb.Stateless;
import javax.interceptor.ExcludeClassInterceptors;
import javax.interceptor.Interceptors;

/**
 * make the AccountService intercepted
 * any method within this class is intercepted
 *
 * every time a method on this class is called either the upgradeAccount method or the auditAccount method is executed,
 * the method within the LoggerInterceptor is executed and this logger is executed
 * and the name of the method plus its parameters are logged out to the logger
 *
 * You can also intercepts the constructors.
 */
@Stateless
@Interceptors(LoggerInterceptor.class)
public class AccountService {

    public void upgradeAccount(String accountNumber) {
        // add logic
    }

    public void auditAccount(String accountNumber) {
        // add logic
    }

    @ExcludeClassInterceptors
    public void excludedMethod(String exclude) {
        // this method is excluded from the LoggerInterceptor
    }

    public String printMessage(String message) {
        System.out.println(" Executing method : printMessage" + message);
        return "Message is "+message;
    }
}
