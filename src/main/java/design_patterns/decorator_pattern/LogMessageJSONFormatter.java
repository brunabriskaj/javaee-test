package design_patterns.decorator_pattern;

import design_patterns.decorator_pattern.thirdpartylogger.LogMessage;

import javax.annotation.Priority;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import javax.json.bind.JsonbBuilder;

@Decorator
@Priority(20)
public abstract class LogMessageJSONFormatter implements LogMessage {

    @Any
    @Inject
    @Delegate
    private LogMessage logMessage;

    @Override
    public void printMessage() {
        String message = logMessage.getMessage();

        // JsonbBuilder => create a json representation of the message
        String jsonMessage = JsonbBuilder.create().toJson(message);
        logMessage.setMessage(jsonMessage);
    }

}