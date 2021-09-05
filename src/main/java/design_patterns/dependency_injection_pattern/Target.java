package design_patterns.dependency_injection_pattern;


import javax.inject.Inject;

/**
 *  the container will inject an instance of the subject into an instance of the target
 *  the container will instantiate an instance of maths and inject it into the target class
 *  it is also possible to inject an instance based on its interface type => in this case the container will inject a Math class because it is of type Subject
 *
 *  What if other classes implement the same interface?
 *  How does the container know which one to inject?
 *  Answer: it will throw an exception at application startup complaining about an ambiguous dependency. Use qualifiers.
 */
public class Target {

    @Favourites
    @Inject
    Subject subject;
}
