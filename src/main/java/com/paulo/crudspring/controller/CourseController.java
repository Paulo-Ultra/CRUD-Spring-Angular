package com.paulo.crudspring.controller;

import com.paulo.crudspring.model.Course;
import com.paulo.crudspring.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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

}
