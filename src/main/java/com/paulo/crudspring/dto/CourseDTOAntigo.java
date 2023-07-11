//package com.paulo.crudspring.dto;
//
//import com.fasterxml.jackson.annotation.JsonProperty;
//import jakarta.persistence.Column;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.Pattern;
//import lombok.Data;
//import org.hibernate.validator.constraints.Length;
//
//@Data
////Padrão sem uso do records
//public class CourseDTO {
//
//    private Long id;
//
//    @NotBlank
//    @NotNull
//    @Length(min = 5, max = 100)
//    private String name;
//
//    @NotNull
//    @Length(max = 10)
//    @Pattern(regexp = "Back-end|Front-end")
//    private String category;
//
//    @NotNull
//    @Length(max = 10)
//    @Pattern(regexp = "Active|Inactive")
//    private String status = "Active";
//
//}
