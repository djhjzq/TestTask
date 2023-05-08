package com.group.testtask;

import com.group.testtask.data.Degree;
import com.group.testtask.data.DegreeEnum;
import com.group.testtask.data.Department;
import com.group.testtask.data.Lector;
import com.group.testtask.repo.DegreeRepository;
import com.group.testtask.repo.DepartmentRepository;
import com.group.testtask.repo.LectorRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;

@Component
@AllArgsConstructor
public class TestData {

    private final DegreeRepository degreeRepository;
    private final LectorRepository lectorRepository;
    private final DepartmentRepository departmentRepository;


    @PostConstruct
    public void init() {
        initDegree();
        initLector();
        initDepartment();
    }

    public void initDegree() {

        degreeRepository.save(new Degree(1L, DegreeEnum.professor));
        degreeRepository.save(new Degree(2L, DegreeEnum.assistant));
        degreeRepository.save(new Degree(3L, DegreeEnum.associate_professor));
    }

    public void initLector() {
        Degree professor = degreeRepository.findById(1L).get();
        Degree assistant = degreeRepository.findById(2L).get();
        Degree associate_professor = degreeRepository.findById(3L).get();

       lectorRepository.save(new Lector(1L, "Emily Adams", professor, BigDecimal.valueOf(600)));
       lectorRepository.save(new Lector(2L, "Jacob Lee", professor,  BigDecimal.valueOf(444)));
       lectorRepository.save(new Lector(3L, "Ava Patel", professor,  BigDecimal.valueOf(1254)));
       lectorRepository.save(new Lector(4L, "Ethan Kim", professor,  BigDecimal.valueOf(700)));
       lectorRepository.save(new Lector(5L, "Mia Chen", assistant,  BigDecimal.valueOf(631)));
       lectorRepository.save(new Lector(6L, "Noah Singh", assistant,  BigDecimal.valueOf(742)));
       lectorRepository.save(new Lector(7L, "Isabella Rodriguez", assistant,  BigDecimal.valueOf(833)));
       lectorRepository.save(new Lector(8L, "William Davis", associate_professor,  BigDecimal.valueOf(821)));
       lectorRepository.save(new Lector(9L, "Sophia Nguyen", associate_professor,  BigDecimal.valueOf(232)));
       lectorRepository.save(new Lector(10L, "Michael Martinez", associate_professor,  BigDecimal.valueOf(444)));
    }

    public void initDepartment() {
        ArrayList<Lector> lectors1 = new ArrayList<>();
        ArrayList<Lector> lectors2 = new ArrayList<>();
        ArrayList<Lector> lectors3 = new ArrayList<>();

        lectors1.add(lectorRepository.findById(1L).get());
        lectors1.add(lectorRepository.findById(5L).get());
        lectors1.add(lectorRepository.findById(8L).get());

        lectors2.add(lectorRepository.findById(2L).get());
        lectors2.add(lectorRepository.findById(6L).get());
        lectors2.add(lectorRepository.findById(10L).get());


        lectors3.add(lectorRepository.findById(3L).get());
        lectors3.add(lectorRepository.findById(4L).get());
        lectors3.add(lectorRepository.findById(7L).get());
        lectors3.add(lectorRepository.findById(9L).get());



        departmentRepository.save(new Department(1L, "Computer_science", lectors1, lectorRepository.findById(1L).get()));
        departmentRepository.save(new Department(2L, "Chemistry", lectors2, lectorRepository.findById(2L).get()));
        departmentRepository.save(new Department(3L, "Sport", lectors3, lectorRepository.findById(3L).get()));



    }

}
