package com.switchfully.funiversity.service.dto;

import lombok.Data;

@Data
public class CourseDTO {

    private String id;
    private String name;
    private int studyPoints;

    private String professorId;
    private String professorName;

}
