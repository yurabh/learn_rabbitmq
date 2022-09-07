package com.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@ToString
@Data
public class Employee {
    private String employeeName;
    private String employeeId;
}
