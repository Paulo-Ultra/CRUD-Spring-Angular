package com.paulo.crudspring.service;

import com.paulo.crudspring.dto.CourseDTO;
import com.paulo.crudspring.dto.mapper.CourseMapper;
import com.paulo.crudspring.enums.CategoryEnum;
import com.paulo.crudspring.exception.RecordNotFoundException;
import com.paulo.crudspring.repository.CourseRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.stream.Collectors;

@Validated
@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;
    public CourseService(CourseRepository courseRepository, CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }

    public List<CourseDTO> list() {
        return courseRepository.findAll()
                .stream()
//                .map(course -> courseMapper.toDTO(course)) -- Forma sem ser a simplificada debaixo
                .map(courseMapper::toDTO)
                .collect(Collectors.toList());
        /*
        Forma de instanciar dtos sem uso de um mapper
        List<Course> courses = courseRepository.findAll();
        List<CourseDTO> dtos = new ArrayList<>(courses.size());
        for(Course course : courses) {
            CourseDTO dto =  new CourseDTO(course.getId(), course.getName(), course.getCategory());
            dtos.add(dto);
        }
        return dtos; */
    }

    public CourseDTO findById(@NotNull @Positive Long id) {
        return courseRepository.findById(id)
                .map(courseMapper::toDTO)
                .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public CourseDTO create(@Valid @NotNull CourseDTO course) {
        return courseMapper.toDTO(courseRepository.save(courseMapper.toEntity(course)));
    }

    public CourseDTO update(@NotNull @Positive Long id, @Valid @NotNull CourseDTO course) {
        return courseRepository.findById(id)
                .map(recordFound -> {
                    recordFound.setName(course.name());
                    recordFound.setCategory(CategoryEnum.FRONT_END);
                    return courseMapper.toDTO(courseRepository.save(recordFound));
                }).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public void delete(@NotNull @Positive Long id) {
        courseRepository.delete(courseRepository.findById(id)
                .orElseThrow(()-> new RecordNotFoundException(id)));

//        courseRepository.findById(id)
//                .map(recordFound -> {
//                    courseRepository.deleteById(id);
//                    return true;
//                }).orElseThrow(() -> new RecordNotFoundException(id));
    }
}
