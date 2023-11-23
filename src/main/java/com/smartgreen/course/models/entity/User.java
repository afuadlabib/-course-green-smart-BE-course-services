package com.smartgreen.course.models.entity;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@CompoundIndex(def = "{'email': 1, 'password': 0}", unique = true)
public class User {
    @Id
    String id;
    @NotNull
    @NotBlank
    @Indexed(unique = true, background = true)
    private String email;
    @NotNull
    @NotBlank
    private String password;
    @JsonEnumDefaultValue
    private Role role = Role.USER;
}
