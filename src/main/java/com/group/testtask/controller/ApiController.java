package com.group.testtask.controller;

import com.group.testtask.data.Department;
import com.group.testtask.data.Lector;
import com.group.testtask.repo.LectorRepository;
import com.group.testtask.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;

@Controller
@AllArgsConstructor
@ShellComponent
public class ApiController {


    private final DepartmentService departmentService;
    private final LectorRepository lectorRepository;

    @ShellMethod(key = "Who is the head of department")
    public String getHeadOfDepartment(@ShellOption(help = "Department name") String departmentName) {
        return departmentService.getHeadOfDepartment(departmentName);
    }

    @ShellMethod(key = {"Show {departmentName} statistics.", "Show"})
    public String showDepartmentStatistics(@ShellOption(help = "Department name") String departmentName) {

        Optional<Department> optDepartment = departmentService.getDepartmentByName(departmentName);

        if(optDepartment.isEmpty()) {
            return "Can't find department";
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("assistants -");

        Department department = optDepartment.get();
        Long assistants = 0L;
        Long associate_professors = 0L;
        Long professors = 0L;
        for (Lector l: department.getList()) {
            if (l.getDegree().getId() == 1) {
                assistants++;
            }
            if(l.getDegree().getId() ==2) {
                associate_professors++;
            }
            else {
                professors++;
            }
        }

        stringBuilder.append(assistants).append("\nassociate_professors-")
                .append(associate_professors).append("\nprofessors-").append(professors);
        return stringBuilder.toString();
    }

    @ShellMethod(key = "Show the average salary for the department")
    public String showAverageSalaryDepartment(@ShellOption(help = "Department name") String departmentName) {
        Optional<Department> optDepartment = departmentService.getDepartmentByName(departmentName);

        if(optDepartment.isEmpty()) {
            return "Can't find department";
        }

        StringBuilder stringBuilder = new StringBuilder();

        Department department = optDepartment.get();

        BigDecimal salary = BigDecimal.valueOf(0);

        for(int i = 0; i < department.getList().size(); i++) {
            salary = salary.add(BigDecimal.valueOf(department.getList().get(i).getSalary().doubleValue()));
        }

        stringBuilder.append("The average salary of ");
        stringBuilder.append(departmentName).append("is ")
                .append(salary.divide(BigDecimal.valueOf(department.getList().size())));

        return stringBuilder.toString();
    }

    @ShellMethod(key = "Show count of employee for")
    public long showCountOfEmployee(@ShellOption(help = "Department name") String departmentName) {

        Optional<Department> optDepartment = departmentService.getDepartmentByName(departmentName);

        if(optDepartment.isEmpty()) {
            return -1;
        }

        Department department = optDepartment.get();

        return department.getList().size();
    }

    @ShellMethod(key = "Global search by")
    public String globalSearch(@ShellOption(help = "Template") String template) {

        StringBuilder stringBuilder = new StringBuilder();

        ArrayList<String> list = new ArrayList<>();

        ArrayList<Lector> lectors = new ArrayList<>(lectorRepository.findByNameContaining(template));

        for(Lector lector: lectors) {
            list.add(lector.getName());
        }

        for(int i = 0; i< list.size(); i++) {
            if(i != list.size() - 1) {
                stringBuilder.append(list.get(i)).append(", ");
            }
            else {
                stringBuilder.append(list.get(i));
            }

        }
        return stringBuilder.toString();
    }
}
