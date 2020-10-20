package com.switchfully.funiversity.api;

import com.switchfully.funiversity.business.entity.Course;
import com.switchfully.funiversity.service.CourseService;
import com.switchfully.funiversity.service.dto.CourseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/courses")
public class CourseController {

    private CourseService service;

    @Autowired
    public CourseController(CourseService service) {
        this.service = service;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<CourseDTO> getAll(){
        return service.getAll();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public CourseDTO getCourseById(@PathVariable String id){
        return service.getCourseById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public CourseDTO addCourse(@RequestBody CourseDTO courseDTO){
        return service.addCourse(courseDTO);
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public CourseDTO updateCourse(@PathVariable String id, @RequestBody CourseDTO courseDTO){
        return service.updateCourse(id, courseDTO);
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public CourseDTO deleteCourse(@PathVariable String id){
        return service.deleteCourse(id);
    }

}
