package com.group.testtask.data;

import com.group.testtask.data.Base.Named;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Setter
public class Lector extends Named {

    @ManyToMany
    private List<Department> departmentList = new ArrayList<>();

    @ManyToOne
    private Degree degree;

    public Lector(Long id, String name, Degree degree, BigDecimal salary) {
        super(id, name);
        this.degree = degree;
        this.salary = salary;
    }

    private BigDecimal salary;


}