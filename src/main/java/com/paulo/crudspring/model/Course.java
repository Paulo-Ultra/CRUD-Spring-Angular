package com.paulo.crudspring.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
//Para mapear caso o nome da tabela seja diferente da criada aqui
//@Table(name = "cursos")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 200, nullable = false)
    private String name;

    @Column(length = 10, nullable = false)
    private String category;

}
