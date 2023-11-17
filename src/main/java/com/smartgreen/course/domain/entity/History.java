package com.smartgreen.course.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class History {
    Boolean isDeleted = false;
    String createdBy = "";
    String deletedBy = "";
}
