package design_patterns.decorator_pattern.thirdpartylogger;

public interface LogMessage {
    void printMessage();
    String getMessage();
    void setMessage(String message);
}
