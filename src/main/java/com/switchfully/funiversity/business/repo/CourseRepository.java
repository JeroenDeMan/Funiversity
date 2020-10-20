package com.switchfully.funiversity.business.repo;

import com.switchfully.funiversity.business.entity.Course;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
@Data
public class CourseRepository {

    private Map<String, Course> courses;

    public CourseRepository() {
        this.courses = new HashMap<>();
    }

    public Course save(Course course){
        if(course == null) throw new IllegalArgumentException("No data provided");

        courses.put(course.getId(), course);
        return course;
    }

    public Course delete(String id){
        return courses.remove(id);
    }
}
