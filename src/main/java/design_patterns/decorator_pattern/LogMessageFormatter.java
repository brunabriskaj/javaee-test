package design_patterns.decorator_pattern;

import design_patterns.decorator_pattern.thirdpartylogger.LogMessage;
import sun.rmi.runtime.Log;

import javax.annotation.Priority;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import java.time.LocalDate;

/**
 * making the decorator class abstract keeps the decorator
 * free of methods that don't relate to the behavior you want to decorate.
 */
@Decorator
@Priority(10)
public abstract class LogMessageFormatter implements LogMessage {

    @Any
    @Delegate
    @Inject
    private LogMessage logMessage = this;

    @Override
    public void printMessage() {
        // print message with a new behaviour; the way that you want
        String message = logMessage.getMessage();
        message = LocalDate.now().toString().concat(message);
        logMessage.setMessage(message);
    }
}
