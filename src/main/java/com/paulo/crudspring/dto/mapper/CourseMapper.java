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
        return new CourseDTO(course.getId(), course.getName(), course.getCategory().getValue());
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
        //Todo: use a mapper foi Category
        course.setCategory(convertCategoryValue(courseDTO.category()));
        return course;
    }

    public CategoryEnum convertCategoryValue(String value) {
        if(value == null) {
            return null;
        }
        return switch (value) {
            case "Front-end" -> CategoryEnum.FRONT_END;
            case "Back-end" -> CategoryEnum.BACK_END;
            default ->  throw new IllegalArgumentException("Categoria Inválida: " + value);
        };
    }
}
