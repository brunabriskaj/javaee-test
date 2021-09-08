package design_patterns.interceptor_pattern;

import javax.interceptor.AroundConstruct;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.transaction.Transactional;

/**
 * @javax.transaction.Transactional is an interceptor binding introduced in Java EE 7.
 * The proxy injected by CDI for your bean will intercept annotated method calls to wrap them in a transaction.
 *
 * doMethodLogging is an interceptor method
 *
 * @AroundInvoke only intercepts method calls, it does not intercepts constructors
 * @AroundConstruct intercepts constructors
 */

@Interceptor
@Transactional
public class LoggerInterceptor {

    @AroundInvoke
    public Object intercept(InvocationContext context) throws Exception {

        // implement the logic you want to be executed before each method
        // log out the method name and the parameter values passed to the method that the method interceptor intercepts.
        System.out.println("LoggerInterceptor - Logging before calling method : "+ context.getMethod().getName() );

        Object result = context.proceed();

        System.out.println("LoggerInterceptor - Logging after calling method : "+ context.getMethod().getName() );

        return result;
    }


    @AroundConstruct
    public void doClassLogging(InvocationContext context) throws Exception {
       //  measure the time it takes to construct a class - create a timer
        long start = System.currentTimeMillis();
        context.proceed();
        // after the constructor returns find what the end time is
        long end =  System.currentTimeMillis();
        System.out.println("Execution time: " + (end - start));
    }

}
