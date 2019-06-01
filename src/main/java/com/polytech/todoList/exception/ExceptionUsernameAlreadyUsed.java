package com.polytech.todoList.exception;

public class ExceptionUsernameAlreadyUsed extends Exception {

    private String username_defined;

    public ExceptionUsernameAlreadyUsed(String username_defined) {
        this.username_defined = username_defined;
    }

    public ExceptionUsernameAlreadyUsed(String message, String username_defined) {
        super(message);
        this.username_defined = username_defined;
    }

    public ExceptionUsernameAlreadyUsed(String message, Throwable cause, String username_defined) {
        super(message, cause);
        this.username_defined = username_defined;
    }

    public ExceptionUsernameAlreadyUsed(Throwable cause, String username_defined) {
        super(cause);
        this.username_defined = username_defined;
    }

    public String toString(){
        return ("Le username "+username_defined+" est deja pris");
    }
}
