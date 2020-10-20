package com.switchfully.funiversity.exception;

import com.switchfully.funiversity.exception.ProfessorAlreadyExists;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProfessorAlreadyExists.class)
    protected void professorAlreadyExistsException(ProfessorAlreadyExists ex, HttpServletResponse response) throws IOException{
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(ProfessorNotFoundException.class)
    protected void professorNotFoundException(ProfessorNotFoundException ex, HttpServletResponse response) throws IOException{
        response.sendError(HttpServletResponse.SC_NOT_FOUND, ex.getMessage());
    }
}
