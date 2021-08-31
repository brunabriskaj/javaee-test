package design_pattern;

import design_patterns.decorator_pattern.LogMessageFormatter;
import design_patterns.decorator_pattern.thirdpartylogger.LogMessage;
import design_patterns.decorator_pattern.thirdpartylogger.LogMessageImplementation;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class LogMessageTest {

    @Test
    public void whenDecoratorsInjectedAtRuntime_thenConfigSuccess() {
        LogMessage logMessage = new LogMessageImplementation();


        LogMessage logMessage2 = new LogMessageFormatter() {
            String message;
            @Override
            public String getMessage() {
                return message;
            }
            @Override
            public void setMessage(String message) {
                this.message = message;
            }
        };

        logMessage2.setMessage("The first example!");
        logMessage2.printMessage();

        assertEquals(logMessage.getMessage(),
                "Hello!");
        assertEquals(logMessage2.getMessage(), LocalDate.now() + "The first example!");

}}
