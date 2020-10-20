package com.switchfully.funiversity.service.mapper;

import com.switchfully.funiversity.business.entity.Course;
import com.switchfully.funiversity.business.entity.Professor;
import com.switchfully.funiversity.service.dto.CourseDTO;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {

    public Course toEntity(CourseDTO courseDTO){
        return new Course(courseDTO.getName(), courseDTO.getProfessorId(), courseDTO.getStudyPoints());
    }

    public CourseDTO toDto(Course course){
        CourseDTO result = new CourseDTO();
        result.setId(course.getId());
        result.setName(course.getName());
        result.setStudyPoints(course.getStudyPoints());
        result.setProfessorId(course.getProfessorId());

        // To make it more flexible it would be better to not include information of the professor directly in the course.
        // But couple them just by both id's. In the new layers you can combine them and create DTO from there.
        // now you have to include information in this class.

        return result;
    }
}
