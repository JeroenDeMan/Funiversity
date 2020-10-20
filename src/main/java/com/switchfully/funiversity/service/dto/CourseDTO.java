package com.switchfully.funiversity.service.dto;

import lombok.Data;

@Data
public class CourseDTO {

    private String id;
    private String professorId;
    private String name;
    private int studyPoints;

    private String professorName;



    @Override
    public String toString() {
        return "CourseDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", studyPoints=" + studyPoints +
                ", professorId='" + professorId + '\'' +
                ", professorName='" + professorName + '\'' +
                '}';
    }
}
