package spring.intro.exeption;

public class AuthenticationException extends Exception {
    public AuthenticationException(String message) {
        super(message);
    }

    public AuthenticationException(String message, Exception exception) {
        super(message, exception);
    }
}
