package com.switchfully.funiversity.service;


import com.switchfully.funiversity.business.entity.Course;
import com.switchfully.funiversity.business.repo.CourseRepository;
import com.switchfully.funiversity.service.dto.CourseDTO;
import com.switchfully.funiversity.service.dto.ProfessorDTO;
import com.switchfully.funiversity.service.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {
    private ProfessorService professorService;
    private CourseRepository repository;
    private CourseMapper mapper;

    @Autowired
    public CourseService(CourseRepository repository, CourseMapper mapper, ProfessorService professorService) {
        this.repository = repository;
        this.mapper = mapper;
        this.professorService = professorService;
    }

    private CourseDTO addProfessorName(CourseDTO courseDTO){
        ProfessorDTO professor = professorService.getProfessorById(courseDTO.getProfessorId());
        courseDTO.setProfessorName(professor.getFullName());
        return courseDTO;
    }

    public List<CourseDTO> getAll(){
       return  repository.getCourses()
                .values()
                .stream()
                .map(course -> mapper.toDto(course))
                .map(this::addProfessorName)
                .collect(Collectors.toList());
    }

    public CourseDTO getCourseById(String id){
        CourseDTO result = mapper.toDto(repository.getCourses().get(id));
        addProfessorName(result);

        return result;
    }

    public CourseDTO addCourse(CourseDTO courseDTO){
        Course result = repository.save(mapper.toEntity(courseDTO));
        return addProfessorName(mapper.toDto(result));
    }

    public CourseDTO updateCourse(String id, CourseDTO courseDTO){
        Course result = repository.getCourses().get(id);
        result.setName(courseDTO.getName());
        result.studyPointIsValid(courseDTO.getStudyPoints());
        result.setProfessorId(courseDTO.getProfessorId());

        return getCourseById(id);
    }

    public CourseDTO deleteCourse(String id){

        Course result = repository.delete(id);
        return addProfessorName(mapper.toDto(result));
    }

}
