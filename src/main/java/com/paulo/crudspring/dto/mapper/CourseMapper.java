package com.paulo.crudspring.dto.mapper;

import com.paulo.crudspring.dto.CourseDTO;
import com.paulo.crudspring.enums.CategoryEnum;
import com.paulo.crudspring.model.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {

    public CourseDTO toDTO(Course course) {
        if (course == null) {
            return null;
        }
        return new CourseDTO(course.getId(), course.getName(), "FRONTEND");
    }

    public Course toEntity(CourseDTO courseDTO) {
        if (courseDTO == null) {
            return null;
        }
        Course course = new Course();
        if(courseDTO.id() != null) {
            course.setId(courseDTO.id());
        }
        course.setName(courseDTO.name());
        course.setCategory(CategoryEnum.FRONT_END);
        course.setStatus("Active");
        return course;
    }
}
