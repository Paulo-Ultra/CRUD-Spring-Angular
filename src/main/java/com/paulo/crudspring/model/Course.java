package com.paulo.crudspring.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.paulo.crudspring.enums.CategoryEnum;
import com.paulo.crudspring.enums.StatusEnum;
import com.paulo.crudspring.enums.converters.CategoryConverter;
import com.paulo.crudspring.enums.converters.StatusConverter;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.Length;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
//Para mapear caso o nome da tabela seja diferente da criada aqui
//@Table(name = "cursos")
@SQLDelete(sql = "UPDATE Course SET status = 'Inativo' WHERE id = ?")
@Where(clause = "status = 'Ativo'")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("_id")
    private Long id;

    @NotBlank
    @NotNull
    @Length(min = 5, max = 100)
    @Column(length = 100, nullable = false)
    private String name;

    @NotNull
    @Column(length = 10, nullable = false)
    @Convert(converter = CategoryConverter.class)
    private CategoryEnum category;

    @NotNull
    @Column(length = 10, nullable = false)
    @Convert(converter = StatusConverter.class)
    private StatusEnum status = StatusEnum.ACTIVE;

    @OneToMany(cascade = CascadeType.ALL,
                orphanRemoval = true,
                mappedBy = "course")
    private List<Lesson> lessons = new ArrayList<>();
}
