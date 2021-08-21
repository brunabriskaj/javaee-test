package design_patterns.singleton_pattern;

import javax.annotation.PostConstruct;
import javax.ejb.DependsOn;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Singleton - lazy instantiation singleton - is a bean that is creatd the first time that is used or requested (by default)
 *            - singleton bean is thread-safe by default -> a method or class instance can be used by multiple threads at the same time without any problems occurring.
 *
 * @Startup  - eager initialization - the class will get instantiated during the application startup process
 *           - the EJB container must initialize the singleton session bean upon application startup
 *           - the singleton session bean is initialized before the EJB container delivers client requests to any enterprise beans in the application
 *           - allows the singleton session bean to perform, for example, application startup tasks
 *
 * @PostConstruct - the method will be invoked after the successful construction of the Singleton Bean itself
 * @DependsOn - when your bean depend by another bean(this bean provides the central services that our Singleton
 * needs such as db connections, web services or configurations of some sorts). In our example the PoolManager bean
 * will initialized only if Configuration bean is initialized successfully.
 *
 * JEE offers two types of concurrency management:
 *          1. container-managed concurrency
 *          2. bean-manged concurrency
 */
@DependsOn("Configuration")
@Startup
@Singleton
public class PoolManager {
    private Queue<Object> pooledObject;

    public PoolManager() {

    }

    @PostConstruct
    public void constructExpensiveObjects() {
        pooledObject = new LinkedBlockingQueue<>(1_000);
        for (int i = 0; i < 1000; i++) {
            pooledObject.add(new Object());
        }
    }

    public void returnObject(Object object) {
        pooledObject.offer(object);
    }

    public Object borrowObject() {
        return pooledObject.poll();
    }

    // used for test
    public boolean methodToTest() {
        return true;
    }

    //used for test
    public int pooledObjectSize() {
        return pooledObject.size();
    }

}
