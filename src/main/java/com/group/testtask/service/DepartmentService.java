package com.group.testtask.service;

import com.group.testtask.data.Department;
import com.group.testtask.repo.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public Optional<Department> getDepartmentByName(String departmentName) {
        return departmentRepository.findByName(departmentName);
    }


    public String getHeadOfDepartment(String departmentName) {

        StringBuilder string = new StringBuilder();

        Optional<Department> departmentOptional = departmentRepository.findByName(departmentName);

        return departmentOptional.map(department -> string.append(department.getHeadOfDepartment()
                .getName()).toString()).orElseGet(() -> string.append("Department not found").toString());

    }



}
