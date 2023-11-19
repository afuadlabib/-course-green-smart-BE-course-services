package com.smartgreen.course.models.entity;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.transaction.annotation.Transactional;


@Document(collection = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Transactional
public class User {
    @Autowired
    @Indexed(unique = true)
    private String username;
    private String password;
    @JsonEnumDefaultValue
    private Role role;

}
