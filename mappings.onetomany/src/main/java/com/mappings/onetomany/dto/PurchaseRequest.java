package com.mappings.onetomany.dto;

import com.mappings.onetomany.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PurchaseRequest {
    public Student student;
}
