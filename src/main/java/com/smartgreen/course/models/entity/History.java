package com.smartgreen.course.models.entity;

import lombok.Data;

@Data
public class History {
    Boolean isDeleted = false;
    String createdBy = "";
    String deletedBy = "";
}
