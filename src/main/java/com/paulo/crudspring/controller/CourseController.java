package com.paulo.crudspring.controller;

import com.paulo.crudspring.model.Course;
import com.paulo.crudspring.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@AllArgsConstructor
public class CourseController {

    private final CourseRepository courseRepository;

    //@RequestMapping(method = RequestMethod.GET) -> Ou usa GetMapping ou dessa forma, não há diferença prática
    @GetMapping
    public @ResponseBody List<Course> list() {

        return courseRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Course create(@RequestBody Course course) {
        //Com ResponseEntity
        //return ResponseEntity.status(HttpStatus.CREATED).body(courseRepository.save(course));

       return courseRepository.save(course);
    }
}
