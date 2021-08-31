package design_patterns.decorator_pattern.thirdpartylogger;

public class LogMessageImplementation implements LogMessage {

    String message = "Hello!";

    @Override
    public void printMessage() {
        System.out.println(message);
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }
}
