package com.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Data
@ToString
public class Employee {
    private String employeeName;
    private String employeeId;
}
