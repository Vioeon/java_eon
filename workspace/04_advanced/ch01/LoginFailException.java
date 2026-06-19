package ch01;

public class LoginFailException extends RuntimeException{
    public LoginFailException(String message){
        super(message);
    }
}
