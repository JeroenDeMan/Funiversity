package com.switchfully.funiversity.service.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ProfessorDTO {

    private String id;
    private String firstName;
    private String lastName;

    public String getFullName(){
        return firstName + " " + lastName;
    }
}
