package com.switchfully.funiversity.business.entity;

import lombok.Data;

import java.util.UUID;

@Data
public class Course {
    public static final int MIN_STUDY_POINTS = 1;
    public static final int MAX_STUDY_POINTS = 6;

    private final String id;
    private String professorId;
    private String name;
    private int studyPoints;

    public Course(String name, String professorId, int studyPoints) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.professorId = professorId;
        studyPointIsValid(studyPoints);
    }

    public void studyPointIsValid(int studyPoints){
        if(studyPoints >= MIN_STUDY_POINTS && studyPoints <= MAX_STUDY_POINTS){
            this.studyPoints = studyPoints;
        } else throw new IllegalArgumentException("Study point is not between " + MIN_STUDY_POINTS + " and " + MAX_STUDY_POINTS);
    }
}
