package com.switchfully.funiversity.exception;

public class ProfessorAlreadyExists extends RuntimeException {
    private String errorMessage;

    public ProfessorAlreadyExists(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String getMessage() {
        return errorMessage;
    }
}
