package com.switchfully.funiversity.exception;

public class ProfessorNotFoundException extends RuntimeException{

    private String errorMessage;

    public ProfessorNotFoundException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String getMessage() {
        return "Professor with id: " +errorMessage + " is not found in the database";
    }
}
